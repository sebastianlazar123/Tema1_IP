public class Main {
    public static void main(String args[])
    {
        MyCrawler crawler=MyCrawler.getInstance();
        crawler.init(args);
        crawler.run();

    }
    }
