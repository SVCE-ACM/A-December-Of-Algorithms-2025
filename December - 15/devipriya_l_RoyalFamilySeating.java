import java.util.*;

public class devipriya_l_RoyalFamilySeating {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                seenNull = true;
            } else {
                if (seenNull) return false;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;
    }
}
