package linkedlist;

public class rotateList {
    public static void main(String[] args) {
        
    }

    public ListNode rotateRightChangingHead(ListNode head, int k) {
        if(head==null||head.next==null||k==0)return head;
        int length=1;
        ListNode l=head;
        while(l.next!=null){
            length++;
            l=l.next;
        }
        l.next=head;
        int rotation=k % length;
        int skip=length-rotation;
        ListNode newLast=head;
        for(int i=0;i<skip-1;i++){
            newLast=newLast.next;
        }
        head=newLast.next;
        newLast.next=null;
        return head;
    }



    public ListNode rotateRightReverseApproach(ListNode head, int k) {
        if(head==null||head.next==null||k==0)return head;
        int length=0;
        ListNode l=head;
        while(l!=null){
            length++;
            l=l.next;
        }
        ListNode ptr=head;
        for(int i=0;i<k%length;i++){
            ListNode newStart=reverse(ptr);
            ptr=newStart.next;
            ListNode second=reverse(ptr);
            newStart.next = second;
            head = newStart;
            ptr = head;
        }
        return head;
    }
    private ListNode reverse(ListNode head) {
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
}
