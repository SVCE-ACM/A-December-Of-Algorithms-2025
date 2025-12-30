import java.util.*;

public class Day28_SweetRewardsForStudents {
    public static void main(String[] args){ Scanner sc=new Scanner(System.in); int n=sc.nextInt(); int[] a=new int[n]; for(int i=0;i<n;i++) a[i]=sc.nextInt(); int[] l=new int[n]; Arrays.fill(l,1); for(int i=1;i<n;i++) if(a[i]>a[i-1]) l[i]=l[i-1]+1; int[] r=new int[n]; Arrays.fill(r,1); for(int i=n-2;i>=0;i--) if(a[i]>a[i+1]) r[i]=r[i+1]+1; long sum=0; for(int i=0;i<n;i++) sum+=Math.max(l[i],r[i]); System.out.println(sum); sc.close(); }
}
