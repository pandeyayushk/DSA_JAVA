package OOPS.singletonClasses;

public class singleton {
    int num;
    private singleton(){};
    private static singleton instance;
    public static singleton getInstance(){
        if(instance==null){
            instance=new singleton();
        }
        return instance;
    }
}
