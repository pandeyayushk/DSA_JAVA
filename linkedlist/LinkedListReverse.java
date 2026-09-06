package linkedlist;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListReverse {

    static ListNode reverse(ListNode head) {
        ListNode ptr = head;
        ListNode preptr = null;
        ListNode postptr;

        while (ptr != null) {
            postptr = ptr.next;   
            ptr.next = preptr;    
            preptr = ptr;        
            ptr = postptr;       
        }
        return preptr; 
    }
    //Can be used whn we keep track of head and tail
    // static void reverseRecursive(ListNode node){
    //     if(head==tail){
    //         head=tail;
    //         return;
    //     }
    //     reverseRecursive(head.next, tail);
    //     tail.next=head;
    //     tail=head;
    //     tail.next=null;
    // }

    static void printList(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + "-->");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Original List:");
        printList(head);
        head = reverse(head);
        System.out.println("Reversed List:");
        printList(head);
    }

    // Between A given Range
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right==left)return head;
        ListNode prev=null,ptr=head,postptr;
        for(int i=0;i<left-1;i++){
            prev=ptr;
            ptr=ptr.next;
        }
        ListNode before=prev,ne=ptr;
        for(int i=0;ptr!=null&&i<right-left+1;i++){
            postptr=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=postptr;
        }
        if(before!=null){
            before.next=prev;
        }else{
            head=prev;
        }
        ne.next=ptr;
        return head;
    }
}



