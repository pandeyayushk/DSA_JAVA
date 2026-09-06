package linkedlist;

// Given the head of a linked list and an integer k, reverse every alternate group of k nodes, 
// starting with the first group.
// If the number of nodes left at the end of the list is fewer than k, 
// reverse these remaining nodes or leave them in their original order, depending on the alternation pattern.
public class reverseAlternativeKGroups {
    public static void main(String[] args) {
        
    }
    public ListNode kAltReverse(ListNode head, int k) {
        return reverseGroups(head,null,k,1);
        
    }
    static ListNode reverseGroups(ListNode head,ListNode before,int k,int count){
        if(head == null) return null;
        ListNode toIndex=head;
        for(int i=0;i<k;i++){
            if(toIndex==null) break;
            toIndex=toIndex.next;
        };
        if(count%2!=0){
            ListNode ptr=head;
            ListNode newHead=reverse(ptr,toIndex);
            head.next=toIndex;
            if(before!=null)before.next=newHead;
            reverseGroups(toIndex,head,k,count+1);
            return newHead;
        }else{
            ListNode last = head;
            while(last.next != toIndex) {
                last = last.next;
            }
            reverseGroups(toIndex, last, k, count + 1);
            return head;
        }
    }
    static ListNode reverse(ListNode head,ListNode tail){
        ListNode prev=null,curr=head,post;
        while(curr!=tail){
            post=curr.next;
            curr.next=prev;
            prev=curr;
            curr=post;
        }
        return prev;
    }
}

