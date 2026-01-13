import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

public class charusm03_burnBinaryTreeTarget {
    public static void main(String[] args) {
        // Build tree manually or via input
        // Example for testing
        TreeNode root = new TreeNode(14);
        root.left = new TreeNode(21);
        root.right = new TreeNode(24);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        // Target
        int target = 14;

        burnTree(root, target);
    }

    static void burnTree(TreeNode root, int target) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode targetNode = findParent(root, null, parent, target);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(targetNode);
        visited.add(targetNode);

        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> step = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                step.add(cur.val);
                if (cur.left != null && visited.add(cur.left))
                    q.add(cur.left);
                if (cur.right != null && visited.add(cur.right))
                    q.add(cur.right);
                if (parent.get(cur) != null && visited.add(parent.get(cur)))
                    q.add(parent.get(cur));
            }
            System.out.println(String.join(", ", step.stream().map(String::valueOf).toArray(String[]::new)));
        }
    }

    static TreeNode findParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> map, int target) {
        if (node == null)
            return null;
        map.put(node, par);
        if (node.val == target)
            return node;
        TreeNode left = findParent(node.left, node, map, target);
        if (left != null)
            return left;
        return findParent(node.right, node, map, target);
    }
}
