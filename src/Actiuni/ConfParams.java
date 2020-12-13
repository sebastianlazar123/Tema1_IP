package Actiuni;


public class ConfParams {
    public ConfParams() {
    }

    public int n_threads;//nr dre threaduri
    public int delay;//in mili-secunde
    public String root_Dir; //directorul de pornire... va fi ignorat daca se da parametrul path
    public int log_level; //

    public ConfParams(ConfParams c)
    {
        this.n_threads=c.n_threads;
        this.delay=c.delay;
        this.log_level=c.log_level;
        this.root_Dir=c.root_Dir;
    }
}

