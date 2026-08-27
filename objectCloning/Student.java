package objectCloning;
public class Student implements Cloneable{
    private String name;
    private int marks;
    public Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }

    /***
     * Cloning like this is not good
     *  */
    public Student(Student other){
        this.name=other.name;
        this.marks=other.marks;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}