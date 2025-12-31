package Dec15;
import java.util.*;
public class CompleteBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            // left child
            if (i < arr.length && arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                q.offer(curr.left);
            }
            i++;

            // right child
            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean seenNull = false;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                seenNull = true;
            } else {
                if (seenNull) return false;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // number of nodes
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        System.out.println(isCompleteTree(root));
    }
}
