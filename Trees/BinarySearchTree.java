package Trees;

import java.util.Scanner;

import maths.prime;

//To make binary search tree balanced and really usefull the height difference between any two 
//adjacent nodes must be <=1(balanced binary tree) otherwise it at a point it will start taking 
//O(n) to search element instead of O(log n) and this will discard an important feature of
//binary tree (this will be implemented in AVL trees) 
public class BinarySearchTree {
    private static class Node {
        int data;
        Node left;
        Node right;
        int height;        
        public Node(int data){
            this.data=data;
            this.height=1;
        }
    }
    private Node root;

    public void insertRootNode(Scanner sc){
        System.out.println("Enter root node value:");
        int val=sc.nextInt();
        root=new Node(val);
        populate(sc,root);
    }
    private void populate(Scanner sc, Node node){
        int choice=0;
        while(choice!=2){
            System.out.println("Enter choice:-");
            System.out.println("1. Insert element");
            System.out.println("2. Exit");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter val to insert:");
                    int val=sc.nextInt();
                    root=insertElement(root, val);
                    break;
                case 2:
                    System.out.println("Exiting now...");
                    break;
                default:
                    System.out.println("Invalid choice.Try again!");
                    break;
            }
        }
    }
    private Node insertElement(Node node, int val){
        if(node == null){
            return new Node(val);
        }
        if(val > node.data){
            node.right = insertElement(node.right, val);
        } else {
            node.left = insertElement(node.left, val);
        }
        node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
        return node;
    }
    private int getHeight(Node node){
        return (node==null)?0:node.height;
    }

    public void display(){
        Node temp=root;
        display(temp,"");
    }

    private  void display(Node node,String intendation){
        if(node==null)return;
        System.out.println(intendation+node.data);
        display(node.left,intendation+"\t");
        display(node.right,intendation+"\t");
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node==null) return true;
        return Math.abs(getHeight(node.left)-getHeight(node.right))<=1&&balanced(node.left)&&balanced(node.right);
    }
    
    public void insertSortedArray(int[] nums){
        root=insertSortedArray(nums,0,nums.length-1);
    }
    private Node insertSortedArray(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        Node node = new Node(nums[mid]);
        node.left = insertSortedArray(nums, start, mid - 1);
        node.right = insertSortedArray(nums, mid + 1, end);
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    public void preetyDisplay(){
        preetyDisplay(root,0);
    }
    private void preetyDisplay(Node node,int level){
        if(node==null)return;
        preetyDisplay(node.right,level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------->"+node.data);
        }else{
            System.out.println(node.data);
        }
        preetyDisplay(node.left,level+1);
    }

    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        Scanner sc=new Scanner(System.in);
        bst.insertRootNode(sc);
        bst.preetyDisplay();

        int[] arr={1,2,3,4,5,6,7,8,9};
        bst.insertSortedArray(arr);
        bst.preetyDisplay();
    }
}
