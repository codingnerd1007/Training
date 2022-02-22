package DS_Assessment_1;

/**
 * Created by rahil on 12/10/21.
 */
import java.util.Scanner;
public class Question2
{
    public static void main(String[] args)
    {
        Scanner scannerObj=new Scanner(System.in);
        int sizeOfMAtrix=scannerObj.nextInt();
        int[][] matrix=new int[sizeOfMAtrix][sizeOfMAtrix];
        for(int rows=0;rows<sizeOfMAtrix;rows++)
        {
            for(int columns=0;columns<sizeOfMAtrix;columns++)
            {
                matrix[rows][columns]=scannerObj.nextInt();
            }
        }

    }
}
