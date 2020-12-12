import Actiuni.derivate.descarcaURL;
import Actiuni.derivate.listType;

import java.util.List;

public class Main {
    public static void main(String args[]) {
           // MyCrawler crawler=MyCrawler.getInstance();
            //crawler.init();
            //crawler.run();
            //descarcaURL prima=new descarcaURL("ceva", "url.txt","C:\\Users\\NoComment102\\Desktop\\Proiect 2\\Tema\\Tema1_IP");
            //prima._do();
            listType list=new listType(System.getProperty("user.dir"), "out.txt", "png");
            list._do();
            list._print();
        }
    }
