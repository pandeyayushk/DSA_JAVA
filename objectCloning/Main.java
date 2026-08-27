package objectCloning;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student Ayush=new Student("Ayush",90);
        // This is a faster way to copy objects compared to the copy constructor
        // This is a shallow copy i.e. for non primitives new obj will point to the older ones
        // So change made through one will be reflected in other
        Student Rahul= (Student) Ayush.clone();
    }
}