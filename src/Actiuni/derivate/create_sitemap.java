package Actiuni.derivate;

import Actiuni.Action;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class create_sitemap extends Action{
    public create_sitemap(String nm, String pm) //param e folderul unde avem site-ul pentru sitemap
    {
        super(nm,pm);
    }

    public void _do()
    {
        listType local=new listType(param,"types.txt","css");
        local._do();
        try (FileWriter map = new FileWriter("sitemap.txt")) {
            map.write(param+"\n");
            map.write("\t"+"css/\n");
            FileReader file_in=new FileReader("types.txt");
            Scanner myReader = new Scanner(file_in);
            if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String array[]=data.split(" ");
                for(String tmp:array)
                map.write("\t\t\t"+tmp+"\n");

                if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            }

            local=new listType(param,"types.txt","png");
            local._do();
            map.write("\t"+"images/\n");
            file_in=new FileReader("types.txt");
            myReader = new Scanner(file_in);
            if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String array[]=data.split(" ");
                for(String tmp:array)
                    map.write("\t\t\t"+tmp+"\n");

                if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            }

            local=new listType(param,"types.txt","jpg");
            local._do();
            file_in=new FileReader("types.txt");
            myReader = new Scanner(file_in);
            if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String array[]=data.split(" ");
                for(String tmp:array)
                    map.write("\t\t\t"+tmp+"\n");

                if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            }

            local=new listType(param,"types.txt","jpeg");
            local._do();
            file_in=new FileReader("types.txt");
            myReader = new Scanner(file_in);
            if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String array[]=data.split(" ");
                for(String tmp:array)
                    map.write("\t\t\t"+tmp+"\n");

                if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            }

            local=new listType(param,"types.txt","pdf");
            local._do();
            map.write("\t"+"pdfs/\n");
            file_in=new FileReader("types.txt");
            myReader = new Scanner(file_in);
            if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String array[]=data.split(" ");
                for(String tmp:array)
                    map.write("\t\t\t"+tmp+"\n");

                if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            }

            local=new listType(param,"types.txt","js");
            local._do();
            map.write("\t"+"js/\n");
            file_in=new FileReader("types.txt");
            myReader = new Scanner(file_in);
            if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String array[]=data.split(" ");
                for(String tmp:array)
                    map.write("\t\t\t"+tmp+"\n");

                if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            }

            local=new listType(param,"types.txt","html");
            local._do();
            map.write("\t"+"html/\n");
            file_in=new FileReader("types.txt");
            myReader = new Scanner(file_in);
            if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String array[]=data.split(" ");
                for(String tmp:array)
                    map.write("\t\t\t"+tmp+"\n");

                if(myReader.hasNextLine()) map.write("\t\t"+myReader.nextLine()+"\n");
            }

            map.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
