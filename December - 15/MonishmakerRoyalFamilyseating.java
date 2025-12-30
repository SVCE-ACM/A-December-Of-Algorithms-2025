import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class TreeNode{
    int val;
    TreeNode left,right;

    TreeNode(int val){
        this.val = val;
        left=right=null;
    }
}

public class MonishmakerRoyalFamilyseating{
    public static TreeNode buildTree(Integer[] arr){
        if(arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while(i<arr.length){
            TreeNode curr = q.poll();

            if(i<arr.length && arr[i] != null){
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;
            if(i<arr.length && arr[i] != null){
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean foundNull = false;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                foundNull = true;
            }else{
                if(foundNull)
                    return false;

                q.add(curr.left);
                q.add(curr.right);
            }

        }
        return true;
    }
    public static void main(String [] arg){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++){
            String s = sc.next();
            if(s.equals("null"))
                arr[i] = null;
            else
                arr[i] = Integer.parseInt(s);
        }
        TreeNode root = buildTree(arr);
        System.err.println(isCompleteTree(root));

    }
}