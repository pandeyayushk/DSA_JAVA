package linkedlist;

import java.util.NoSuchElementException;

public class dll<T>{
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        T data;
        Node next;
        Node prev;
        public Node(T data){
            this.data=data;
        }
    }
    public void add(T num){
        Node node=new Node(num);
        node.next=head;
            if(head==null){
                tail=node;
            }else{
                head.prev=node;
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
        node.prev=tail;
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
        Node node=new Node(num);
        node.next=ptr.next;
        node.prev=ptr;
        ptr.next.prev=node;
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
        }else{
            head.prev=null;
        }
        return val;
    }
    public T removeLast() throws NoSuchElementException{
        if(tail==null){
            throw new NoSuchElementException("List is empty, nothing to remove.");
        }
        T val=tail.data;
        if(head==tail){
            head=null;
            tail=null;
        }else{
            tail=tail.prev;
            tail.next=null;
        }
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
        ptr.next.prev=ptr;
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
    public void displayForward(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    public void displayBackward(){
        Node temp=tail;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.prev;
        }
        System.out.println("NULL");
    }
}
