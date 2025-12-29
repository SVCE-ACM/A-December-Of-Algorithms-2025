import java.util.*;

public class Magesh2424_RoyalFamilySeating {

    // Tree node definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // Check if binary tree is complete
    static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean foundNull = false;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                foundNull = true;
            } else {
                if (foundNull) return false;
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return true;
    }

    // Build tree from level order input
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            if (arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr);

        // Output result
        System.out.println(isCompleteBinaryTree(root));

        sc.close();
    }
}
