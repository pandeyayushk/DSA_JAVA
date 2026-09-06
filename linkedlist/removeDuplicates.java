package linkedlist;


public class removeDuplicates {
    ListNode head;
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void add(int num){
        ListNode node=new ListNode(num,head);
        head=node;
    }
    public void printList() {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + "-->");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        removeDuplicates obj=new removeDuplicates();
        obj.add(3);
        obj.add(3);
        obj.add(2);
        obj.add(1);
        obj.add(1);
        obj.printList();
        obj.head=obj.deleteDuplicates(obj.head);
        obj.printList();
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode ptr=head.next;
        ListNode preptr=head;
        while(ptr!=null){
            if(ptr.val==preptr.val){
                preptr.next=ptr.next;
                ptr=ptr.next;
            }else{
                preptr=ptr;
                ptr=ptr.next;
            }
        }
        return head;
    }
}
