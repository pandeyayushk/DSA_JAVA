package linkedlist;

import java.util.HashMap;
import java.util.Map;

import linkedlist.removeDuplicates.ListNode;

public class detectCycle {
    public static void main(String[] args) {
        
    }
    static boolean pointerApproach(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true;
        }
        return false;
    }
    static int cycleLength(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            int length=1;
            if(slow==fast){
                ListNode ptr=slow.next;
                while(ptr!=slow){
                    length++;
                    ptr=ptr.next;
                }
                return length;
            }
        }
        return 0;
    }
    static boolean mapApproach(ListNode head){
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode ptr=head;
        int pos=0;
        while(ptr!=null){
            if(map.containsKey(ptr)){
                System.out.println(pos-map.get(ptr));
                return true;
            }
            map.put(ptr,pos++);
            ptr=ptr.next;
        }
        return false;
    }
    public static ListNode detectCycleStartMap(ListNode head) {
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode ptr=head;
        int pos=0;
        while(ptr!=null){
            if(map.containsKey(ptr))break;
            map.put(ptr,pos++);
            ptr=ptr.next;
        }
        return (ptr!=null&&ptr.next!=null)?ptr:null;
    }
    public ListNode detectCycleStartPointer(ListNode head) {
        ListNode first=head,second=head;
        int length=cycleLength(head);
        if(length==0)return null;
        for(int i=0;i<length;i++){
            second=second.next;
        }
        while(second!=first){
            second=second.next;
            first=first.next;
        }
        return first;
    }
}
