package DS_Assessment_1;

/**
 * Created by rahil on 12/10/21.
 */
import java.util.Scanner;
public class Question3
{
    class Node
    {
        int data;
        Node right;
        Node left;
        Node(int data)
        {
            this.data=data;
        }
    }
    void compute(int[] input)
    {

    }
    public static void main(String[] args)
    {
        Scanner scannerObj=new Scanner(System.in);
        Question3 question3Obj=new Question3();
        int sizeOfInput=scannerObj.nextInt();
        int input[]=new int[sizeOfInput];
        for(int index=0;index<sizeOfInput;index++)
        {
            input[index]=scannerObj.nextInt();
        }
        question3Obj.compute(input);
    }
}
