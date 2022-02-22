/**
 * Created by rahil on 22/9/21.
 */
// Program using Hash Map
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Program2 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int index=0;index<size;index++)
        {
            input[index]=sc.nextInt();
        }
        int target=sc.nextInt();
        Map<Integer,Integer> solutionMap=new HashMap<Integer,Integer>();
        for(int index=0;index<size;index++)
        {
            solutionMap.put(input[index],index);
        }
        System.out.println(solutionMap.get(target));
    }
}
