package arraylist;

import java.util.*;
/**
 * Created by rahil on 24/9/21.
 */
public class UpdateElementValue {
    public static void updateValue(ArrayList outputList,int toBeUpdated,int updateWith){
        while(outputList.contains(toBeUpdated)){
            outputList.set(outputList.indexOf(toBeUpdated),updateWith);
        }
        /*else
            System.out.println("Value to be update doesn't exist");*/
    }
    public static void main(String args[]){
        ArrayList<Integer> inputList=new ArrayList<Integer>();
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter the values and press -1 to exit enter mode");
        while(true){
            int input=scannerObj.nextInt();
            if(input==-1)break;
            else{
                inputList.add(input);
            }
        }
        System.out.println("enter the element whose value you want to update");
        int toBeUpdated=scannerObj.nextInt();
        System.out.println("enter the value to be updated with");
        int updateWith=scannerObj.nextInt();
        updateValue(inputList,toBeUpdated,updateWith);
        System.out.println(inputList);
    }
}
