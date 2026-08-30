package linkedlist;
import java.util.NoSuchElementException;

public class ll<T>{
    private Node head;
    private Node tail;
    private int size;
    public ll(){
        this.size=0;
    }
    private class Node {
        private T data;
        private Node next;
        public Node(T data){
            this.data=data;
        }
        public Node(T data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    public void printList() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + "-->");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }
    public void add(T num){
        Node node=new Node(num,head);
        if(head==null){
            tail=node;
        }
        head=node;
        size++;
    }
    public void addLast(T num){
        if(tail==null){
            add(num);
            return;
        }
        Node node=new Node(num);
        tail.next=node;
        tail=node;
        size++;
    }
    public void addAt(T num,int index){
        if(index<0||index>size) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0) {
            add(num);
            return;
        }
        if (index == size) {
            addLast(num);
            return;
        }
        Node ptr=head;
        for(int i=0;i<index-1;i++){
            ptr=ptr.next;
        }
        Node node=new Node(num,ptr.next);
        ptr.next=node;
        size++;
    }
    public T removeFirst() throws NoSuchElementException{
        if(head==null){
            throw new NoSuchElementException("List is empty, nothing to remove.");
        }
        T val=head.data;
        head = head.next;
        size--;
        if(head==null){ 
            tail = null;
        }
        return val;
    }
    public T removeLast() throws NoSuchElementException{
        if(tail==null){
            throw new NoSuchElementException("List is empty, nothing to remove.");
        }
        T val;
        if(head==tail){
            val=head.data;
            head=null;
            tail=null;
            size--;
            return val;
        }
        Node ptr=head;
        while(ptr.next!=tail){
            ptr=ptr.next;
        }
        val=tail.data;
        tail=ptr;
        tail.next=null;
        size--;
        return val;
    }
    public T removeAt(int index) throws IndexOutOfBoundsException{
        if(index<0||index>=size) {
            throw new IndexOutOfBoundsException("Invalid Index.");
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size-1) {
            return removeLast();
        }
        Node ptr=head;
        for(int i=0;i<index-1;i++){
            ptr=ptr.next;
        }
        T val=ptr.next.data;
        ptr.next=(ptr.next).next;
        size--;
        return val;
    }
    public T peekFirst(){
        if(head==null){
            System.out.println("List is empty, nothing to peek.");
            return null; 
        }
        return head.data;
    }
    public T peekLast(){
        if(tail==null){
            System.out.println("List is empty, nothing to peek.");
            return null; 
        }
        return tail.data;
    }

    public int getSize(){
        return this.size;
    }
}
