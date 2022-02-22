package arraylist;
import java.util.*;
import java.io.*;
/**
 * Created by rahil on 24/9/21.
 */
public class CreateArrayList{
    public static void print(ArrayList printList){
        System.out.println("printing list of items in array list:"+printList);
        for(int index=0;index<printList.size();index++){
            System.out.print(printList.get(index)+" ");
        }
    }
    public static void main(String args[]){
        ArrayList<String> userInputList = new ArrayList<String>();
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("enter the name of the colour");
        System.out.println("enter 0 to stop entering");
        while(true){
            String input= scannerObj.next();
            if(input.equals("0"))
                break;
            else{
                userInputList.add(input);
            }
        }
        print(userInputList);
    }
}
