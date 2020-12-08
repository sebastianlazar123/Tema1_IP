package Actiuni;

public class Action implements IAction {
        private String name;
        private String param;
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
