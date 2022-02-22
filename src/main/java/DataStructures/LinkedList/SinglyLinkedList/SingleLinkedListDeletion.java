package DataStructures.LinkedList.SinglyLinkedList;

/**
 * Created by rahil on 7/10/21.
 * Deleting a node given a particular key.
 */

import java.util.Scanner;
public class SingleLinkedListDeletion {
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    Node head;
    public void insertAtFront(int data){
        Node newNode =new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public void deleteNode(int deletionKey){
        Node iteratorNode=head;
        Node temporaryNode=null;
        if(iteratorNode!=null &&iteratorNode.data==deletionKey){
            head=head.next;
            return;
        }
        while(iteratorNode!=null && iteratorNode.data!=deletionKey){
            temporaryNode=iteratorNode;
            iteratorNode=iteratorNode.next;
        }
        if(iteratorNode==null){
            System.out.println("No such data found");
            return;
        }
        temporaryNode.next=iteratorNode.next;

    }
    public void printList(){
        Node newNode=head;
        while(newNode!=null){
            System.out.print(newNode.data+" ");
            newNode=newNode.next;
        }
    }
    public static void main(String[] args) {
         Scanner scannerObj=new Scanner(System.in);
         SingleLinkedListDeletion linkedListObj=new SingleLinkedListDeletion();
         System.out.println("Enter the number of entries you wan to enter");
         System.out.println("----------------------------------------------------------------------------------------");
         int numberOfInsertion=scannerObj.nextInt();
         for(int counter=0;counter<numberOfInsertion;counter++) {
            System.out.println("Enter your data");
            System.out.println("-------------------------------------------------------------------------------------");
            linkedListObj.insertAtFront(scannerObj.nextInt());
            System.out.println("-------------------------------------------------------------------------------------");
        }

        System.out.println("Enter the value of the node to delete that particular node");
        System.out.println("-----------------------------------------------------------------------------------------");
        linkedListObj.deleteNode(scannerObj.nextInt());
        System.out.println("-----------------------------------------------------------------------------------------");
        linkedListObj.printList();
    }
}
