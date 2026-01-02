import java.util.*;

public class BurnTheBinaryTreeFromTargetNode {
    static class Node {
        int val;
        Node left, right;
        Node(int v){ val = v; }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        String line = sc.nextLine().trim();
        String[] values = line.split(",");
        
        Node root = makeTree(values);
        
        System.out.print("Target node = ");
        int target = sc.nextInt();
        
        HashMap<Node, Node> parent = new HashMap<>();
        Node targetNode = findNode(root, target, parent);
        
        if(targetNode == null){
            System.out.println("Target not found");
            return;
        }
        
        HashSet<Node> burned = new HashSet<>();
        LinkedList<Node> q = new LinkedList<>();
        q.add(targetNode);
        burned.add(targetNode);
        
        while(!q.isEmpty()){
            int sz = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for(int x=0; x<sz; x++){
                Node cur = q.removeFirst();
                level.add(cur.val);
                
                if(cur.left != null && !burned.contains(cur.left)){
                    burned.add(cur.left);
                    q.add(cur.left);
                }
                if(cur.right != null && !burned.contains(cur.right)){
                    burned.add(cur.right);
                    q.add(cur.right);
                }
                if(parent.containsKey(cur) && !burned.contains(parent.get(cur))){
                    burned.add(parent.get(cur));
                    q.add(parent.get(cur));
                }
            }
            
            String out = "";
            for(int x=0; x<level.size(); x++){
                out += level.get(x);
                if(x < level.size()-1) out += ", ";
            }
            System.out.println(out);
        }
        sc.close();
    }
    
    static Node makeTree(String[] arr){
        if(arr.length == 0 || arr[0].trim().equals("null") || arr[0].trim().isEmpty()){
            return null;
        }
        
        Node root = new Node(Integer.parseInt(arr[0].trim()));
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        
        int idx = 1;
        while(!q.isEmpty() && idx < arr.length){
            Node cur = q.removeFirst();
            
            if(idx < arr.length && !arr[idx].trim().equals("null") && !arr[idx].trim().isEmpty()){
                cur.left = new Node(Integer.parseInt(arr[idx].trim()));
                q.add(cur.left);
            }
            idx++;
            
            if(idx < arr.length && !arr[idx].trim().equals("null") && !arr[idx].trim().isEmpty()){
                cur.right = new Node(Integer.parseInt(arr[idx].trim()));
                q.add(cur.right);
            }
            idx++;
        }
        
        return root;
    }
    
    static Node findNode(Node root, int target, HashMap<Node, Node> parent){
        if(root == null) return null;
        
        Node found = null;
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node cur = q.removeFirst();
            
            if(cur.val == target) found = cur;
            
            if(cur.left != null){
                parent.put(cur.left, cur);
                q.add(cur.left);
            }
            if(cur.right != null){
                parent.put(cur.right, cur);
                q.add(cur.right);
            }
        }
        
        return found;
    }
}
