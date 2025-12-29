import java.util.*;

public class Magesh2424_BurnBinaryTreeFromTargetNode {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level order input
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                q.offer(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // Map parents and find target node
    static TreeNode mapParents(TreeNode root, int target,
                               Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode targetNode = null;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        return targetNode;
    }

    // Burn tree starting from target
    static void burnTree(TreeNode targetNode,
                         Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(targetNode);
        visited.add(targetNode);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                System.out.print(curr.val);

                if (i < size - 1) System.out.print(", ");

                // Left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                // Right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                // Parent
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Read target node
        int target = sc.nextInt();

        TreeNode root = buildTree(arr);

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = mapParents(root, target, parentMap);

        if (targetNode != null) {
            burnTree(targetNode, parentMap);
        }

        sc.close();
    }
}
