package arraylist;
import java.util.*;
import java.io.*;
/**
 * Created by rahil on 24/9/21.
 */
public class ArrayListInsertFirst {
    public static void printList(ArrayList outputList){
        System.out.println(outputList);
    }
    public static void main(String args[]){
        Scanner scannerObj=new Scanner(System.in);
        ArrayList<Integer> inputList=new ArrayList<Integer>();
        System.out.println("enter the numbers you want to enter");
        System.out.println("enter -1 to stop enter ing input");
        while(true){
            int input=scannerObj.nextInt();
            if(input==-1)
                break;
            else{
                inputList.add(0,input);
            }
        }
        printList(inputList);

    }
}
