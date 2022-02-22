package DataStructures.LinkedList.SinglyLinkedList;

/**
 * Created by rahil on 7/10/21.
 */


import java.util.Scanner;
public class SingleLinkedListInsertion{
    public class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    private Node head;
     void insertFront(){
        Scanner scannerObj=new Scanner(System.in);
        System.out.println("Enter the data you want to enter");
        int insertFrontInput=scannerObj.nextInt();
        System.out.println("---------------------------------------------------------------------");
        Node newNode=new Node(insertFrontInput);
        newNode.next=head;
        head=newNode;
    }
    private void insertEnd() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter the data you want to enter");
        int insertEndInput = scannerObj.nextInt();
        System.out.println("---------------------------------------------------------------------");
        Node newNode = new Node(insertEndInput);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = null;
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next=newNode;
        }
    }
    private void insert(){
        Scanner scannerObj=new Scanner(System.in);
        System.out.println("Enter the data you want to enter");
        int insertInput=scannerObj.nextInt();
        System.out.println("Enter the key after which you want to enter the data");
        int key=scannerObj.nextInt();
        System.out.println("---------------------------------------------------------------------");
        Node itterratorNode;
        itterratorNode=head;
        Node newNode=new Node(insertInput);
        boolean check=false;
        while(itterratorNode.next!=null){
            if(itterratorNode.data==key)
            {
                newNode.next=itterratorNode.next;
                itterratorNode.next=newNode;
                check=true;
            }
            itterratorNode=itterratorNode.next;
        }
        if(check==false){
            System.out.println("No such element found");
        }
    }
    private void print(){
        Node newNode=head;
        while(newNode!=null){
            System.out.print(newNode.data+" ");
            newNode=newNode.next;
        }

    }
    public static void main(String[] args) {
        Scanner scannerObj=new Scanner(System.in);
        SingleLinkedListInsertion linkedListObject=new SingleLinkedListInsertion();
        do{
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Press 1 to Insert at end");
            System.out.println("Press 2 to insert at front");
            System.out.println("Pres 3 to insert at the index you want to");
            System.out.println("Press 4 to exit");
            System.out.println("---------------------------------------------------------------------");
            int userInput=scannerObj.nextInt();
            System.out.println("---------------------------------------------------------------------");
            if(userInput==1)
                linkedListObject.insertEnd();
            else if(userInput==2)
                linkedListObject.insertFront();
            else if(userInput==3)
                linkedListObject.insert();
            else if(userInput==4)
                break;
            else
                System.out.println("Wrong Input!,Please enter your choice again");

        }while (true);
        linkedListObject.print();
    }
}
