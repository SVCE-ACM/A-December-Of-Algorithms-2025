import java.util.*;

public class devipriya_l_BurnBinaryTree {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static Map<Node, Node> parent = new HashMap<>();

    static Node mapParents(Node root, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.val == target) targetNode = cur;
            if (cur.left != null) {
                parent.put(cur.left, cur);
                q.add(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right, cur);
                q.add(cur.right);
            }
        }
        return targetNode;
    }

    public static void burnTree(Node root, int target) {
        Node start = mapParents(root, target);

        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                level.add(cur.val);

                if (cur.left != null && visited.add(cur.left))
                    q.add(cur.left);
                if (cur.right != null && visited.add(cur.right))
                    q.add(cur.right);
                if (parent.containsKey(cur) && visited.add(parent.get(cur)))
                    q.add(parent.get(cur));
            }

            for (int i = 0; i < level.size(); i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(level.get(i));
            }
            System.out.println();
        }
    }
}
