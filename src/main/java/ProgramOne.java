/**
 * Created by rahil on 22/9/21.
 */

// This program uses HashSet

import java.util.HashSet;
import java.util.Scanner;
public class ProgramOne {
    static void solution(int[] nums,int target){
        HashSet<Integer> numberSet=new HashSet<>();
        for(int value:nums){
            numberSet.add(value);
            if(numberSet.contains(target-value)){
                System.out.println(value+" "+(target-value));
                break;
            }
        }

    }
    static void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of array");
        int length=sc.nextInt();
        int[] input=new int[length];
        for(int counter=0;counter<length;counter++){
            input[counter]=sc.nextInt();
        }
        int target=sc.nextInt();
        solution(input,target);
    }
    public static void main(String args[]){
        input();
    }
}
