package Dec01;
import java.util.*;
public class SquaresOfNumbers {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int k=s.nextInt();
        int count=0;
        for(int i=1;i*i<k;i++)
        {
            System.out.print(i*i+" ");
            count++;
        }
        System.out.println( );
        System.out.println(count);
    }

}
