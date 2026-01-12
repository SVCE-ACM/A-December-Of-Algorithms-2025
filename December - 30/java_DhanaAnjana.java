import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class java_DhanaAnjana {
    static class TreeNode {
        int val;
        TreeNode left, right, parent;
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine().replace("[", "").replace("]", "");
        String[] values = input.split(",");
        
        TreeNode root = buildTree(values);
        int target = scanner.nextInt();
        
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        findNode(root, target, nodeMap);
        
        if (!nodeMap.containsKey(target)) {
            System.out.println();
            scanner.close();
            return;
        }
        
        TreeNode targetNode = nodeMap.get(target);
        burnTree(root, targetNode);
        
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
    
    static void findNode(TreeNode node, int target, Map<Integer, TreeNode> nodeMap) {
        if (node == null) return;
        
        nodeMap.put(node.val, node);
        
        if (node.left != null) {
            node.left.parent = node;
            findNode(node.left, target, nodeMap);
        }
        
        if (node.right != null) {
            node.right.parent = node;
            findNode(node.right, target, nodeMap);
        }
    }
    
    static void burnTree(TreeNode root, TreeNode targetNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> burned = new HashMap<>();
        
        queue.add(targetNode);
        burned.put(targetNode, true);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder line = new StringBuilder();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (i > 0) line.append(", ");
                line.append(node.val);
                
                if (node.left != null && !burned.containsKey(node.left)) {
                    burned.put(node.left, true);
                    queue.add(node.left);
                }
                
                if (node.right != null && !burned.containsKey(node.right)) {
                    burned.put(node.right, true);
                    queue.add(node.right);
                }
                
                if (node.parent != null && !burned.containsKey(node.parent)) {
                    burned.put(node.parent, true);
                    queue.add(node.parent);
                }
            }
            
            System.out.println(line.toString());
        }
    }
}
