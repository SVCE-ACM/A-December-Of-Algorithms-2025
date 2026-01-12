import java.util.*;

public class RoyalFamilySeating {
    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int d){ data = d; }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine().trim();
        inp = inp.replace("root = ", "").replace("[", "").replace("]", "");
        String[] vals = inp.split(",");
        
        if(vals.length == 0 || vals[0].trim().equals("null")){
            System.out.println(true);
            return;
        }
        
        TreeNode root = createTree(vals);
        boolean result = checkComplete(root);
        System.out.println(result);
        sc.close();
    }
    
    static TreeNode createTree(String[] arr){
        if(arr.length == 0 || arr[0].trim().equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[0].trim()));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int idx = 1;
        while(!q.isEmpty() && idx < arr.length){
            TreeNode curr = q.removeFirst();
            
            if(idx < arr.length && !arr[idx].trim().equals("null")){
                curr.left = new TreeNode(Integer.parseInt(arr[idx].trim()));
                q.add(curr.left);
            }
            idx++;
            
            if(idx < arr.length && !arr[idx].trim().equals("null")){
                curr.right = new TreeNode(Integer.parseInt(arr[idx].trim()));
                q.add(curr.right);
            }
            idx++;
        }
        return root;
    }
    
    static boolean checkComplete(TreeNode root){
        if(root == null) return true;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean sawNull = false;
        
        while(!q.isEmpty()){
            TreeNode node = q.removeFirst();
            
            if(node == null){
                sawNull = true;
            }
            else{
                if(sawNull) return false;
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
    }
}
