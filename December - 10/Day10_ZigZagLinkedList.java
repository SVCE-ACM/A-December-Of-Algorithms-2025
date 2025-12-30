import java.util.*;

public class Day10_ZigZagLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i=0;i<N;i++) a.add(sc.nextInt());
        int l=0,r=N-1;
        StringJoiner sj = new StringJoiner(" ");
        while (l<=r){ if(l==r){sj.add(String.valueOf(a.get(l)));break;} sj.add(String.valueOf(a.get(l))); sj.add(String.valueOf(a.get(r))); l++; r--; }
        System.out.println(sj.toString()); sc.close();
    }
}
