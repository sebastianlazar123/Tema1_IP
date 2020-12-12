package Actiuni.derivate;

import Actiuni.Action;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.OutputStreamWriter;

public class listType extends Action {
    protected String type;


    public listType(String nm, String pm, String type) {
        super(nm,pm);
        this.type=type;
    }

    public void _do()
    {
        this.name+="\\mta.ro";
        File directoryPath = new File(this.name);
        File[] filesList = directoryPath.listFiles();

        try
        {
            FileWriter myWriter = new FileWriter(param);
            System.out.println("Writing to file...\n");

            for(File file : filesList) {
                int ver=0;
                //System.out.println("File path: "+file.getAbsolutePath());
                //System.out.println("Size :"+file.getTotalSpace());
                //System.out.println(" ");

                try {
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {

                        String data = myReader.nextLine();
                        String regex="[^\\/\\'\"\\-]+\\."+type;
                        Pattern pattern=Pattern.compile(regex);
                        Matcher match = pattern.matcher(data);
                        //writer.println(data.substring(match.start(),match.end()));
                        while(match.find()) {
                            if(ver==0)
                            {
                                myWriter.write(file.getName());
                                myWriter.write("\n");
                                ver=1;
                            }
                            myWriter.write(data.substring(match.start(),match.end()));
                            myWriter.write(" ");
                        }
                        if(ver==1)
                            myWriter.write("\n");
                    }
                    myReader.close();
                }
                catch (FileNotFoundException e) {
                    System.out.println("An error occurred reading files!");
                    e.printStackTrace();
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //aici
    }

    public void _print(){
        System.out.println(this.name);
    }
}
