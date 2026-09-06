package linkedlist;

import linkedlist.removeDuplicates.ListNode;

public class mergeSortList {
    public static void main(String[] args) {
        
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode mid=getMiddleNode(head);
        ListNode right=mid.next;
        mid.next=null;
        ListNode left=sortList(head);
        right=sortList(right);
        return mergeLists(left,right);
    }
    private ListNode getMiddleNode(ListNode head) {
        ListNode slow=head,fast=head,prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return prev;
    }
    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode merge=new ListNode();
        ListNode ptr1=list1;
        ListNode ptr2=list2;
        ListNode ptr3=merge;
        while(ptr1!=null&&ptr2!=null){
            if(ptr1.val<ptr2.val){
                ptr3.next=ptr1;
                ptr1=ptr1.next;
            }else{
                ptr3.next=ptr2;
                ptr2=ptr2.next;
            }
            ptr3=ptr3.next;
        }
        ptr3.next = (ptr1 != null) ? ptr1 : ptr2;
        return merge.next;
    }
}
