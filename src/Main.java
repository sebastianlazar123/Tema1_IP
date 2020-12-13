import Actiuni.derivate.descarcaURL;
import Actiuni.derivate.listType;
import Actiuni.derivate.searchFor;
import Actiuni.derivate.create_sitemap;
import java.util.List;

public class Main {
    public static void main(String args[]) {
            MyCrawler crawler=MyCrawler.getInstance();
            crawler.init(args);
            crawler.run();
            //descarcaURL prima=new descarcaURL("ceva", "url.txt","C:\\Users\\NoComment102\\Desktop\\Proiect 2\\Tema\\Tema1_IP");
            //prima._do();
//            listType list=new listType(System.getProperty("user.dir"), "out.txt", "png");
//            list._do();
//            list._print();
            //new searchFor("C:\\Users\\Lazar Sebastian\\Desktop\\git\\Tema1_IP\\mta.ro","cerc")._do();
          //  create_sitemap map=new create_sitemap("facem sitemap din","mta.ro");
           // map._do();
        }
    }
