package Dec02;
import java.util.*;
public class totalOfDistinctValues {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=1;i<=n;i++)
        {
            System.out.println(i+" "+Integer.toOctalString(i)+" "+Integer.toHexString(i)+" "+Integer.toBinaryString(i));
        }
    }

}
