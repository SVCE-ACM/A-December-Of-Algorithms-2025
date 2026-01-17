import java.util.*;

public class BurnBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(21);
        root.right = new TreeNode(24);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(12);
        root.right.right = new TreeNode(14);

        root.left.left.left = new TreeNode(22);
        root.left.left.right = new TreeNode(23);
        root.left.right.right = new TreeNode(13);

        int target = 14;

        burnTree(root, target);
    }

    static void burnTree(TreeNode root, int target) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = buildParentMap(root, parentMap, target);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(targetNode);
        visited.add(targetNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> burning = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                burning.add(curr.val);

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.add(curr.right);
                }
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }

            for (int i = 0; i < burning.size(); i++) {
                System.out.print(burning.get(i));
                if (i != burning.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    static TreeNode buildParentMap(TreeNode root,
                                   Map<TreeNode, TreeNode> parentMap,
                                   int target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode targetNode = null;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.val == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.add(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
        return targetNode;
    }
}
