package linkedlist;

public class palindrome {
    public static void main(String[] args) {
        
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=reverse(slow);
        while(mid!=null){
            if(mid.val==head.val){
                head=head.next;
                mid=mid.next;
            }else{
                return false;
            }
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null,ptr=head,post;
        while(ptr!=null){
            post=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=post;
        }
        return prev;
    }
}
