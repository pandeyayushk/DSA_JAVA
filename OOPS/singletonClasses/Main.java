package OOPS.singletonClasses;

public class Main {
    public static void main(String[] args) {
        singleton obj=singleton.getInstance();
        singleton obj1=singleton.getInstance();
        obj.num=10;
        System.out.println(obj1.num);
    }
}
