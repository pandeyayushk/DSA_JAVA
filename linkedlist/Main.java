package linkedlist;


public class Main {
    public static void main(String[] args) {
        ll<Integer> ll=new ll<>();
        dll<Integer> dll=new dll<>();
        for(int i=0;i<10;i++){
            ll.add(i);
            dll.add(i*10);
        }
        ll.addAt(1000, 3);
        dll.addAt(1000, 3);
        ll.addLast(-1);
        dll.addLast(-1);
        ll.printList();
        ll.removeAt(3);
        ll.printList();
        dll.displayForward();
        dll.displayBackward();
        dll.removeAt(3);
        dll.displayForward();
        dll.displayBackward();
    }
}
