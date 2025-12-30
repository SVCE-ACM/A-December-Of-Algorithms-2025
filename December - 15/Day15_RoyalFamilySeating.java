import java.util.*;

public class Day15_RoyalFamilySeating {
    static class Node{ Integer val; Node left,right; Node(Integer v){val=v;} }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        line = line.replaceAll("[\[\] ]","");
        if(line.isEmpty()){System.out.println("true");sc.close();return;}
        String[] parts = line.split(",");
        List<Node> nodes = new ArrayList<>();
        for(String p:parts) nodes.add(p.equals("null")?null:new Node(Integer.parseInt(p)));
        for(int i=0;i<nodes.size();i++){ Node n = nodes.get(i); if(n!=null){int l=2*i+1,r=2*i+2; if(l<nodes.size()) n.left=nodes.get(l); if(r<nodes.size()) n.right=nodes.get(r);} }
        boolean res = isComplete(nodes.get(0));
        System.out.println(res);
        sc.close();
    }
    static boolean isComplete(Node root){ if(root==null) return true; Queue<Node> q=new ArrayDeque<>(); q.add(root); boolean end=false; while(!q.isEmpty()){ Node n=q.poll(); if(n==null) end=true; else{ if(end) return false; q.add(n.left); q.add(n.right); } } return true; }
}
