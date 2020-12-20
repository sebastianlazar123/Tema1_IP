package Actiuni.derivate;

import Actiuni.Action;
import Actiuni.ConfParams;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class descarcaURL extends Action {
    public String cale;
    public descarcaURL(String nm, String pm, ConfParams c){
        super(nm, pm, c);
        this.cale=c.root_Dir;
    }

    private void download_page(String webPage_name,String path, int level)
    {
        if (level==this.c.log_level) return;
        try {

            // Create URL object
            String host;
            String regex="[a-zA-Z0-9\\.\\-]+$";
            Pattern pattern=Pattern.compile(regex);
            Matcher match = pattern.matcher(path);

            match.find();
            host=match.group(0);
            int ok=0;

            if(!webPage_name.contains(host)&&webPage_name.contains("http")) return;
            else if(webPage_name.contains(host)) ok=1;

            URL url = new URL(webPage_name);
            BufferedReader readr =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            regex="\\:\\/\\/[a-zA-Z0-9.\\/]*";
            pattern=Pattern.compile(regex);
            match = pattern.matcher(webPage_name);

            match.find();
            String nume=match.group(0);

            String[] file_name_local=nume.split("/",0);
            String file_name="";
            int j=0;
            for(String a:file_name_local)
                if(++j>2) file_name=file_name+"."+a;

            // Enter filename in which you want to download
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(path+"\\"+file_name+".html"));

            // read each line from stream till end
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

            readr.close();
            writer.close();

            System.out.println("Successfully Downloaded.");

            String html=null;
            FileReader filein=new FileReader(path+"\\"+file_name+".html");
            BufferedReader buffer=new BufferedReader(filein);

            boolean eof=false;
            while(!eof)
            {
                String s=buffer.readLine();
                if(s==null)
                {
                    eof=true;
                }
                else
                {
                    if (html==null) {
                        html=s;
                    }
                    else{
                        html=html+" "+s;
                    }
                }
            }

            ArrayList<String> links=new ArrayList<String>();
            Pattern linkPattern = Pattern.compile("<a[^>]+href=[\\\"']?([\\\"'>]+)[\\\"']?[^>]*>(.+?)<\\/a>",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
            Matcher pageMatcher = linkPattern.matcher(html);
            String local_link;
            while(pageMatcher.find()){
                ok=1;
                local_link=pageMatcher.group(0).split(("\""),5)[1];
                if(!local_link.contains("http")) ok=0;
                if(ok==1)
                {
                    links.add(local_link);
                }
                else links.add("https://"+host+"/"+local_link);

            }
            int size= links.size();

            for (int i=0;i<size;i++)
            {
                download_page(links.get(i),path,level+1);
                //System.out.println(i);
            }

            return;

        }

        // Exceptions
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ie) {
            System.out.println("IOException raised");
        }
    }

    public void _do()
    {
        try {
            File myObj = new File(param);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                try {
                    String regex="\\:\\/\\/[a-zA-Z0-9.]*\\/";
                    Pattern pattern=Pattern.compile(regex);
                    Matcher match = pattern.matcher(data);

                    match.find();
                    String nume=match.group(0);

                    String[] dir_name=nume.split("/",5);
                    System.out.println((dir_name[2]));
                    String path=this.cale+"\\"+dir_name[2];
                    Path dir = Paths.get(path);

                    //java.nio.file.Files;
                    if(Files.exists(dir)==false)
                    {
                        Files.createDirectory(dir);
                        System.out.println("Directory is created!");
                    }
                    else
                    {
                        System.out.println("Directory already exists!");
                    }



                    download_page(data,path,0);

                } catch (IOException e) {

                    System.err.println("Failed to create directory!" + e.getMessage());

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}
