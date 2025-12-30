import java.util.*;

public class Day09_SumOfUniqueElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Long,Integer> freq = new HashMap<>();
        for (int i=0;i<N;i++){long v=sc.nextLong();freq.put(v,freq.getOrDefault(v,0)+1);} 
        long sum=0; for(Map.Entry<Long,Integer> e:freq.entrySet()) if(e.getValue()==1) sum+=e.getKey();
        System.out.println(sum); sc.close();
    }
}
