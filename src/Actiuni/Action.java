package Actiuni;

public class Action implements IAction {
        protected String name;
        protected String param;

        protected ConfParams c;
        protected Action(String nm, String pm, ConfParams c){
            this.name=nm;
            this.param=pm;
            this.c=c;
        }
        protected Action(String nm, String pm)
        {
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
