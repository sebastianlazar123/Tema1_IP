public class Action implements IAction {
        protected String name;
        protected String param;

        protected ConfParams config;





        protected Action(String nm, String pm, ConfParams c){
            config =new ConfParams(c);
            this.name=nm;
            this.param=pm;
        }





    public void _do(){
        System.out.println("Sunt o actiune nedefinita");
    }
    public void _print()
    {
        String string=String.format("Numele este %s iar parametrul este %s %s",name,param,config.root_Dir);
        System.out.println(string);

    }


}
