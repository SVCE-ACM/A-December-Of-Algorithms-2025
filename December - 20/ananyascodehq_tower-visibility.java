import java.util.*;

class TowerVisibility {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] heights = new int[N];
        for(int i = 0; i < N; i++){
            heights[i] = sc.nextInt();
        }

        int[] ans = new int[N];
        Stack<Integer> st = new Stack<>();

        for(int i = N - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= heights[i])
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(heights[i]);
        }

        for(int x : ans)
            System.out.print(x + " ");
    }
}
