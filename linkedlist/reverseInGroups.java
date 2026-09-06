package linkedlist;
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. \
// If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is
// You may not alter the values in the list's nodes, only nodes themselves may be changed.
public class reverseInGroups {
    public static void main(String[] args) {
        
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        return reverseGroups(head,null,k);
    }
    private ListNode reverseGroups(ListNode head,ListNode before,int k){
        ListNode toIndex=head;
        for(int i=0;i<k;i++){
            if(toIndex==null)return head;
            toIndex=toIndex.next;
        };
        ListNode ptr=head;
        ListNode newHead=reverse(ptr,toIndex);
        head.next=toIndex;
        if(before!=null)before.next=newHead;
        reverseGroups(toIndex,head,k);
        return newHead;
    }
    private ListNode reverse(ListNode head,ListNode tail){
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
