import java.util.*;

public class Day20_TowerVisibilityChallenge {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); int[] h=new int[N]; for(int i=0;i<N;i++) h[i]=sc.nextInt();
        int[] ans=new int[N]; Arrays.fill(ans,-1);
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            while(!st.isEmpty() && h[i]>h[st.peek()]){ ans[st.pop()]=h[i]; }
            st.push(i);
        }
        for(int i=0;i<N;i++){ if(i>0) System.out.print(" "); System.out.print(ans[i]); } System.out.println(); sc.close();
    }
}
