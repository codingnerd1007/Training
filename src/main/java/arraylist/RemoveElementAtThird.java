package arraylist;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;
/**
 * Created by rahil on 24/9/21.
 */
public class RemoveElementAtThird {
    public static void main(String args[]){
        Scanner scannerObj=new Scanner(System.in);
        ArrayList<Integer> integerList=new ArrayList<Integer>();
        System.out.println("enter the numbers , enter -1 to stop entering numbers");
        while(true){
            int input=scannerObj.nextInt();
            if(input==-1)break;
            else{
                integerList.add(input);
            }
        }
        System.out.println("value removed="+integerList.remove(2));
        System.out.println("content of the list"+integerList);
    }
}
