import java.util.*;

public class SakthiDharan01_burn_binary_tree_from_target {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int target = sc.nextInt();
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) vals.add(sc.nextInt());
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i + 1 < vals.size(); i += 2){
            int u = vals.get(i), v = vals.get(i+1);
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        if (!adj.containsKey(target)){
            System.out.println(target);
            return;
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        seen.add(target);
        q.add(target);
        while (!q.isEmpty()){
            int sz = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < sz; i++){
                int u = q.poll();
                level.add(u);
                for (int nb : adj.getOrDefault(u, Collections.emptyList())){
                    if (!seen.contains(nb)){
                        seen.add(nb);
                        q.add(nb);
                    }
                }
            }
            for (int i = 0; i < level.size(); i++){
                if (i > 0) System.out.print(", ");
                System.out.print(level.get(i));
            }
            System.out.println();
        }
        sc.close();
    }
}
