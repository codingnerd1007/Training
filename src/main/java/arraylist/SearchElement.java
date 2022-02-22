package arraylist;
import java.util.*;
import java.io.*;
/**
 * Created by rahil on 24/9/21.
 */
public class SearchElement {
    public static int findElement(ArrayList outputList,int index){
        int output=0;
       try{
           output=(int)outputList.get(index);
       }
       catch (IndexOutOfBoundsException e){
           System.out.println("No element exists for that index");
           System.out.println(e);
           System.exit(0);
       }
       return output;
    }
    public static void main(String args[]) {
        ArrayList<Integer> inputList=new ArrayList<Integer>();
        Scanner scannerObj=new Scanner(System.in);
        System.out.println("Enter your input, enter -1 to print");
        while(true){
            int input=scannerObj.nextInt();
            if(input==-1)break;
            else{
                inputList.add(input);
            }
        }
        System.out.println("Enter the index to search the element for");
        System.out.println(findElement(inputList,scannerObj.nextInt()));
    }
}
