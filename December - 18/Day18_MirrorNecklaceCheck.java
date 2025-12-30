import java.util.*;

public class Day18_MirrorNecklaceCheck {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); if (N==0){ System.out.println("The necklace is empty."); sc.close(); return; }
        int[] b=new int[N]; for(int i=0;i<N;i++) b[i]=sc.nextInt();
        int l=0,r=N-1; boolean ok=true; while(l<r){ if(b[l++]!=b[r--]){ok=false;break;} }
        System.out.println(ok?"The necklace is mirrored.":"The necklace is not mirrored."); sc.close();
    }
}
