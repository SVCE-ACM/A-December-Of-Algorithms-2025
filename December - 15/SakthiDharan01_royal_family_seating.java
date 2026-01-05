import java.util.*;

public class SakthiDharan01_royal_family_seating {
    private static class Node {
        int val; Node left, right;
        Node(int v){val=v;}
    }

    private static List<String> tokens(String input){
        return Arrays.asList(input.replace(","," ").trim().split("\\s+"));
    }

    private static Node build(List<String> vals){
        if (vals.isEmpty()) return null;
        List<Node> nodes = new ArrayList<>();
        for (String v : vals){
            if (v.equalsIgnoreCase("null")) nodes.add(null);
            else nodes.add(new Node(Integer.parseInt(v)));
        }
        Queue<Node> kids = new ArrayDeque<>();
        for (int i = 1; i < nodes.size(); i++) kids.add(nodes.get(i));
        for (Node n : nodes){
            if (n != null){
                n.left = kids.poll();
                n.right = kids.poll();
            }
        }
        return nodes.get(0);
    }

    private static boolean isComplete(Node root){
        if (root == null) return true;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        boolean end = false;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur == null){
                end = true;
            } else {
                if (end) return false;
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) sb.append(sc.nextLine()).append(' ');
        String input = sb.toString().trim();
        if (input.isEmpty()) return;
        List<String> vals = tokens(input);
        Node root = build(vals);
        System.out.println(Boolean.toString(isComplete(root)).toLowerCase());
        sc.close();
    }
}
