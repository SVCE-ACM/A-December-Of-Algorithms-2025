import java.util.*;

public class charusm03_royalFamilySeating {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example: Build tree manually for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(isCompleteBinaryTree(root));
    }

    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean end = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                end = true;
            } else {
                if (end)
                    return false;
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
}
