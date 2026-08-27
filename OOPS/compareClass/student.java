package OOPS.compareClass;
import java.util.Arrays;

public class student implements Comparable<student>{
    private String name;
    private int marks;
    public student(String name,int marks){
        this.marks=marks;
        this.name=name;
    }
    public int compareTo(student o){
        int diff=-(this.marks-o.marks);
        return diff;
    }
    public String toString() {
        return marks+" ";
    }

    public static void main(String[] args) {
        student ayush=new student("Ayush", 150);
        student rahul=new student("Rahul", 90);
        int diff=ayush.compareTo(rahul);
        if(diff>0){
            System.out.println(ayush.name+" scored more");
        }else if(diff<0){
            System.out.println(rahul.name+" scored more");
        }else{
            System.out.println("Both scored same");
        }
        student[] arr={ayush,rahul};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
