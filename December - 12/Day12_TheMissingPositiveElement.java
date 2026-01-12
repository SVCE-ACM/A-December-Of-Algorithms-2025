import java.util.*;

public class Day12_TheMissingPositiveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i=0;i<N;i++) a[i]=sc.nextInt();
        int i=0;
        while (i<N){ if (a[i]==i+1) i++; else if (a[i]<=0||a[i]>N||a[a[i]-1]==a[i]) i++; else {int t=a[a[i]-1]; a[a[i]-1]=a[i]; a[i]=t;} }
        int missing=-1, duplicate=-1;
        for (int k=0;k<N;k++) if (a[k]!=k+1){ missing=k+1; duplicate=a[k]; break; }
        System.out.println("Missing Number: " + missing);
        System.out.println("Duplicate Number: " + duplicate);
        sc.close();
    }
}
