import java.util.*;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
    }
}

public class MonishmakerBurnTheBinary {

    public static TreeNode buildTree(Scanner sc, int n){
        if(n==0) return null;

        Queue<TreeNode> q = new LinkedList<>();
        int val = sc.nextInt();
        TreeNode root = new TreeNode(val);
        q.add(root);

        int count = 1;

        while(!q.isEmpty() && count<n){
            TreeNode curr = q.poll();

            int leftVal = sc.nextInt();
            count++;
            if(leftVal != -1){
                curr.left = new TreeNode(leftVal);
                q.add(curr.left);
            }
            if(count >= n) break;

            int rightVal = sc.nextInt();
            count++;
            if(rightVal != -1){
                curr.right = new TreeNode(rightVal);
                q.add(curr.right);
            }
        }
        return root;
    }
    
    private static TreeNode mapParents(TreeNode root,Map<TreeNode,TreeNode> parentMap,int target){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode targetNode = null;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val == target)
                targetNode = curr;
            if(curr.left !=null){
                parentMap.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parentMap.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        return targetNode;
    }
    public static void burnTree(TreeNode root,int target){
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        TreeNode start = mapParents(root, parentMap, target);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> burned = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                burned.add(node.val);

                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.add(node.right);
                }
                if(parentMap.containsKey(node)){
                    TreeNode parent = parentMap.get(node);
                    if(!visited.contains(parent)){
                        visited.add(parent);
                        q.add(parent);
                    }
                }
            }
            for(int i=0;i<burned.size();i++){
                System.out.print(burned.get(i));
                if(i<burned.size()-1) System.out.print(",");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeNode root = buildTree(sc,n);
        int target = sc.nextInt();

        burnTree(root,target);
    }
}
