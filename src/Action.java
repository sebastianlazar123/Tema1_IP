package Actiuni;


import java.util.ConcurrentModificationException;

public class Action implements IAction {
        protected String name;
        protected String param;





        protected Action(String nm, String pm){
            this.name=nm;
            this.param=pm;
        }





    public void _do(){
        System.out.println("Sunt o actiune nedefinita");
    }
    public void _print()
    {
        String string=String.format("Numele este %s iar parametrul este %s",name,param);
        System.out.println(string);

    }


}
