package Trees;
import java.util.Scanner;
public class BinaryTree {
    

    private static class Node {
        int data;
        Node left;
        Node right;        
        public Node(int data){
            this.data=data;
        }
    }
    private Node root;

    public void insert(Scanner sc){
        System.out.println("Enter root node value:");
        int val=sc.nextInt();
        root=new Node(val);
        populate(sc,root);
    }

    private void populate(Scanner sc, Node node){
        System.out.println("Do you want to insert left of "+node.data+" :");
        Boolean left=sc.nextBoolean();

        if(left){
            System.out.println("Enter value to insert:");
            int val=sc.nextInt();
            node.left=new Node(val);
            populate(sc, node.left);
        }

        System.out.println("Do you want to insert right of "+node.data+" :");
        Boolean right=sc.nextBoolean();

        if(right){
            System.out.println("Enter value to insert:");
            int val=sc.nextInt();
            node.right=new Node(val);
            populate(sc, node.right);
        }

    }

    public void display(){
        Node temp=root;
        display(temp,"");
        // displayLeft(temp);
        // displayRight(temp);
    }

    private  void display(Node node,String intendation){
        if(node==null)return;
        System.out.println(intendation+node.data);
        display(node.left,intendation+"\t");
        display(node.right,intendation+"\t");
    }

    private void displayLeft(Node node){
        if(node==null)return;
        System.out.println(node.data);
        displayLeft(node.left);
        displayRight(node.right);
    }

    private void displayRight(Node node){
        if(node==null)return;
        System.out.println(node.data);
        displayRight(node.right);
        displayLeft(node.left);
    }

    public void preetyDisplay(){
        preetyDisplay(root,0);
    }
    public void preetyDisplay(Node node,int level){
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
        BinaryTree bt=new BinaryTree();
        Scanner sc=new Scanner(System.in);
        bt.insert(sc);
        bt.display();
        bt.preetyDisplay();
    }
}
