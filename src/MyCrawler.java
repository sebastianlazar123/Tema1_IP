import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MyCrawler {
    private static MyCrawler single_instance = null;

    private String configFile="crawl.conf";//fisierul de configurare utilizat...default este crawl.conf
    private ArrayList<IAction> actions;

    private ConfParams config;      //fisierele de configurare specifice (path, thread-uri, alte cele, le vom tr ca param.

    private MyCrawler()
    {}


    public static MyCrawler getInstance()
    {
        if (single_instance == null)
            single_instance = new MyCrawler();
        return single_instance;
    }


    private void errorConfig()
    {
        System.out.println("Fisier de configurare incorect. Il vom folosi pe cel implicit");
        if(this.configFile.equals("crawl.conf")) {
            System.out.println("Ai compromis si fisierul implicit de conf.\nDescarca unul bun de pehttps://github.com/sebastianlazar123/Tema1_IP ");

        }
        else
        {
            this.configFile="crawl.conf";
            setConfig();

    }
    }

    private void setConfig()
    {
        File conf=new File(configFile);
        int verif=0; //folosit pentru a verifica daca sunt toti parametrii pusi


        try {
            Scanner reader=new Scanner(conf);
            while(reader.hasNext())
            {
                String buffer=reader.nextLine();
                String lines[]=buffer.split("=");

                if(lines[1].isEmpty())
                {
                   errorConfig();
                   return;

                }


                if(lines[0].equals("n_threads"))
                {
                    config.n_threads=parseInt(lines[1]);
                    verif++;
                }
                if(lines[0].equals("delay"))
                {
                    config.delay=parseInt(lines[1]);
                    verif++;

                }
                if(lines[0].equals("root_dir"))
                {
                    config.root_Dir=lines[1];
                    verif++;

                }
                if(lines[0].equals("log_level"))
                {
                    config.log_level=parseInt(lines[1]);
                    verif++;
                }
               // System.out.println(buffer);
            }//aici s-a citit tot fisierul


            if(verif!=4)//daca nu sunt toate valorile, fisierul de configurare nu este bun.
            {
                errorConfig();
                return;
            }



        } catch (FileNotFoundException e) {
            System.out.println("S-a aruncat o exceptie: ");
            e.printStackTrace();
        }



    }



    public void init(String[] args)
    {
        config=new ConfParams();
        actions=new ArrayList<IAction>();




        for(int i=0;i< args.length;i++)//aici facem citirea parametrilor + initierea actiunilor in functie de ce se da
        {//in prima faza ne uitam dupa fisierul de configurare (
            if(args[i].equals("-config")) {
                File file=new File(args[i+1]);
                if(file.exists())
                    configFile=args[i+1];
                else
                    System.out.println("Nu exista fisierul de configurare mentionat\nSe va folosi cel implicit");

               // configFile = args[i + 1];
            }

        }


        setConfig();//pana aici e ok


        //cautam daca avem vreo cale data ca parametru si suprascriem in fisier

        for(int i=0;i<args.length;i++) {

            if(args[i].equals("-setPath"))
                config.root_Dir=args[i+1];



        }

        //de aici o sa facem initializarea actiunilor pe baza parametrilor







        for (int i=0;i<args.length;i++)
        {
            if(args[i].equals("-fUrl"))
            {
                    File file=new File(args[1]);
                    if(file.exists()) {
                        IAction a = new descarcaURL(args[i], args[i + 1], config);
                        actions.add(a);
                    }
                    else
                        System.out.println("Nu exista fisierul descris");



            }

            if(args[i].equals("-getLogs"))
            {
                IAction a = new getLogs(args[i], args[i + 1], config);
                actions.add(a);
            }

            if(args[i].equals("-listType"))
            {
                IAction a = new listType(args[i], args[i + 1], config);
                actions.add(a);
            }

            if(args[i].equals("-searchFor"))
            {
                IAction a = new descarcaURL(args[i], args[i + 1], config);
                actions.add(a);
            }


        }








    }

    public int run()
    {
        //iteratie prin toate actiunile si urmare a suprascrierii metodelor _do
        for(IAction act:actions)
            act._print();
        return 1;

    }
}
