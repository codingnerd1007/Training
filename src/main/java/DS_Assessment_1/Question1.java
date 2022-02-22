package DS_Assessment_1;

/**
 * Created by rahil on 11/10/21.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Question1
{
    Node root;
    boolean answer=true;
    Stack<Node> stackObj=new Stack<Node>();
    Queue<Node> treeNode=new LinkedList<Node>();

    class Node
    {
        String data;
        Node left;
        Node right;

        Node(String data)
        {
            this.data=data;
            left=null;
            right=null;
        }
    }
    void insert(String insertionElement)
    {

        if(root==null)
        {

            treeNode.add(new Node(insertionElement));
        }
        else
        {
            Node removedNode=treeNode.peek();
            if(removedNode.left==null)
            {
                removedNode.left=new Node(insertionElement);
                treeNode.add(removedNode.left);
            }
            else
            {
                removedNode.right=new Node(insertionElement);
                treeNode.add(removedNode.right);
                treeNode.remove();
            }
        }
    }
    void checkLeft(Node iteratorNode)
    {
        if(iteratorNode==null || answer==false)
            return;
        Node previousNode=iteratorNode;
        stackObj.push(iteratorNode);
        iteratorNode=iteratorNode.left;
        if(iteratorNode.data.equals("null"))
            return;
        else if(Integer.parseInt(iteratorNode.data)-Integer.parseInt(previousNode.data)>0)
            {
                answer=false;
                return;
            }
        else
        {
            checkLeft(iteratorNode);
        }

        Node rightSuperNode=stackObj.pop();
        Node newRightNode=rightSuperNode.right;
        if (newRightNode.data.equals("null"))
            return;
        else if(Integer.parseInt(rightSuperNode.data)-Integer.parseInt(newRightNode.data)>0)
        {
            answer=false;
            return;
        }
        else
        {
            checkLeft(newRightNode);
        }
    }
    boolean check()
    {
        Node iteratorNode=root;
        checkLeft(iteratorNode);
        return answer;

    }
    public static void main(String[] args)
    {
        Scanner scannerObj=new Scanner(System.in);
        Question1 treeObj=new Question1();

        String inputString=scannerObj.nextLine();
        String[] usefulString=inputString.split(" ");
        String stringWithoutBraces=usefulString[usefulString.length-1].substring(1,usefulString[usefulString.length-1]
                .length()-1);
        String[] operableString=stringWithoutBraces.split(",");

        for (String x:operableString)
        {
            treeObj.insert(x);
        }

        System.out.println(treeObj.check());

        StringBuffer strbfr=new StringBuffer("abcdef");

    }

}
