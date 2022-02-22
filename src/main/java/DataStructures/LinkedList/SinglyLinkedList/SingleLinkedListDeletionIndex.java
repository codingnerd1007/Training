package DataStructures.LinkedList.SinglyLinkedList;

/**
 * Created by rahil on 8/10/21.
 */
import java.util.Scanner;
public class SingleLinkedListDeletionIndex {
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
    public void deleteNode(int index){
        Node iteratorNode=head;
        Node previousNode=null;
        int count=0;
        if(index==0){
            head=head.next;
            return;
        }
        while(iteratorNode!=null && count!=index){
            previousNode=iteratorNode;
            iteratorNode=iteratorNode.next;
            count++;
        }
        if(iteratorNode==null) {
            System.out.println("you are searching for wrong index");
            return;
        }
        previousNode.next=iteratorNode.next;
    }
    public void print(){
        Node newNode=head;
        while(newNode!=null){
            System.out.print(newNode.data+" ");
            newNode=newNode.next;
        }
    }
    public static void main(String[] args) {
        Scanner scannerObj=new Scanner(System.in);
        SingleLinkedListDeletionIndex linkedListObj=new SingleLinkedListDeletionIndex();

        System.out.println("Enter the number of entries you wan to enter");
        System.out.println("----------------------------------------------------------------------------------------");

        int numberOfInsertion=scannerObj.nextInt();

        for(int counter=0;counter<numberOfInsertion;counter++) {
            System.out.println("Enter your data");
            System.out.println("-------------------------------------------------------------------------------------");
            linkedListObj.insertAtFront(scannerObj.nextInt());
            System.out.println("-------------------------------------------------------------------------------------");
        }

        System.out.println("Enter the value of the Index to delete that particular node");
        System.out.println("-----------------------------------------------------------------------------------------");

        linkedListObj.deleteNode(scannerObj.nextInt());

        System.out.println("-----------------------------------------------------------------------------------------");
        linkedListObj.print();
    }
}
