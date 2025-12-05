import java.util.*;
public class dhanusiyasri_Target_Subarray_Finder{
    public static void target_subarray_finder(int n,int k,int[] arr)
    {int start=-1;
        int end=-1;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=0;
            for(int j=i;j<n;j++)
            {
                sum+=arr[j];
                if(sum==k)
                {
                    start=i;
                    end=j;
                    break;
                }
            }
            if(sum==k)
            {
                break;
            }
        } 
        System.out.println(start+" "+end);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sc.close();
        target_subarray_finder(n, k, arr);
       }
}