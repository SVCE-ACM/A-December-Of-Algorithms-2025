/*
 * Problem: Burning Binary Tree from Target Node
 *
 * Approach:
 * ---------
 * Fire spreads like BFS because every second burns neighbors simultaneously.
 *
 * Steps:
 * 1. Map each node to its parent (tree doesn't normally store parent)
 * 2. Find target node
 * 3. Run BFS from target
 *    Neighbors = left + right + parent
 * 4. Print nodes burning level-by-level
 *
 * Complexity:
 * Time  : O(N)
 * Space : O(N)
 */

import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int v) { val = v; }
}

public class Main {

    static Node buildTree() {
        // Build your tree here or assume it's provided in platform format
        return null;
    }

    static void mapParents(Node root, Map<Node, Node> parent) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.left != null) {
                parent.put(cur.left, cur);
                q.offer(cur.left);
            }

            if (cur.right != null) {
                parent.put(cur.right, cur);
                q.offer(cur.right);
            }
        }
    }

    static Node getTarget(Node root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;

        Node left = getTarget(root.left, target);
        if (left != null) return left;

        return getTarget(root.right, target);
    }

    public static void burnTree(Node root, int target) {
        if (root == null) return;

        Map<Node, Node> parent = new HashMap<>();
        mapParents(root, parent);

        Node start = getTarget(root, target);
        if (start == null) return;

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> burning = new ArrayList<>();

            while (size-- > 0) {
                Node cur = q.poll();
                burning.add(cur.val);

                if (cur.left != null && visited.add(cur.left))
                    q.offer(cur.left);

                if (cur.right != null && visited.add(cur.right))
                    q.offer(cur.right);

                if (parent.containsKey(cur) && visited.add(parent.get(cur)))
                    q.offer(parent.get(cur));
            }

            // print nodes burning at this second
            System.out.println(String.join(", ",
                    burning.stream().map(String::valueOf).toList()));
        }
    }

    public static void main(String[] args) {
        Node root = buildTree();
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        burnTree(root, target);
    }
}
