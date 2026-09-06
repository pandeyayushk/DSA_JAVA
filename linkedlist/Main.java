package linkedlist;
import linkedlist.*;


 

public class Main {
    public static void main(String[] args) {
        // ll<Integer> ll=new ll<>();
        // dll<Integer> dll=new dll<>();
        // for(int i=0;i<10;i++){
        //     ll.add(i);
        //     dll.add(i*10);
        // }
        // ll.insertRec(1000, 3,ll.getHead());
        // ll.printList();
        // ll.setHead(ll.insertRecRet(200, 4,ll.getHead()));
        // dll.addAt(1000, 3);
        // ll.addLast(-1);
        // dll.addLast(-1);
        // ll.printList();
        // ll.removeAt(3);
        // ll.printList();
        // dll.displayForward();
        // dll.displayBackward();
        //dll.removeAt(3);
        // dll.displayForward();
        // dll.displayBackward();
        ll<Integer> rev=new ll<>();
        for(int i=0;i<10;i++){
            rev.addLast(i);
        }
        rev.printList();
        // reverseLinkedList.reverse(rev.getHead());
    }
}
