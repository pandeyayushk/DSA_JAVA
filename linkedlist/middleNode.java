package linkedlist;

import linkedlist.removeDuplicates.ListNode;

public class middleNode {
    public static void main(String[] args) {
        
    }
    public static ListNode getMiddleNode(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
