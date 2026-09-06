package linkedlist;
public class reorderList {

    public static void main(String[] args) {
        
    }
    public void reorderListContinuousReverse(ListNode head) {
        if(head==null||head.next==null)return;
        ListNode before=head;
        ListNode start=head.next;
        while(start.next!=null){
            ListNode newStart=reverse(start);
            before.next=newStart;
            before=before.next;
            start=newStart.next;
        }
        
    }
    private ListNode reverse(ListNode head){
        ListNode ptr=head,prev=null,post;
        while(ptr!=null){
            post=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=post;
        }
        return prev;
    }

    public void reorderListMidReverse(ListNode head) {
        if(head==null||head.next==null)return;
        ListNode mid=findMid(head);
        ListNode rev=reverse(mid);
        while(head!=null&&rev!=null){
            ListNode tempHead=head.next;
            head.next=rev;
            ListNode tempRev=rev.next;
            rev.next=tempHead;
            head=tempHead;
            rev=tempRev;
        }
        if(head!=null)head.next=null;
    }
    private ListNode findMid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}