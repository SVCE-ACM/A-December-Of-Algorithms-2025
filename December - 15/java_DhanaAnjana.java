import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class java_DhanaAnjana {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        String[] values = input.replace("[", "").replace("]", "").split(",");
        
        TreeNode root = buildTree(values);
        
        System.out.println(isCompleteBinaryTree(root) ? "true" : "false");
        scanner.close();
    }
    
    static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].trim().isEmpty()) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            
            if (i < values.length && !values[i].trim().isEmpty()) {
                node.left = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.add(node.left);
            }
            i++;
            
            if (i < values.length && !values[i].trim().isEmpty()) {
                node.right = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.add(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean seenNull = false;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                seenNull = true;
            } else {
                if (seenNull) return false;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        return true;
    }
}
