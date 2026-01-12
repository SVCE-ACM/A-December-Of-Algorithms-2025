import java.util.*;

public class TreasureTrailAdjustment {
    static class Node {
        int val;
        Node next;
        Node(int v){ val = v; }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        
        String[] parts = line.split(",");
        String headStr = parts[0].replace("head = ", "").replace("[", "").replace("]", "").trim();
        String nStr = parts[1].replace("n = ", "").trim();
        
        int n = Integer.parseInt(nStr);
        
        if(headStr.isEmpty() || headStr.length() == 0){
            System.out.println("[]");
            return;
        }
        
        String[] values = headStr.split(" ");
        
        Node dummy = new Node(0);
        Node ptr = dummy;
        for(String v : values){
            if(!v.trim().isEmpty()){
                ptr.next = new Node(Integer.parseInt(v.trim()));
                ptr = ptr.next;
            }
        }
        
        Node first = dummy;
        Node second = dummy;
        
        for(int x=0; x<=n; x++){
            first = first.next;
        }
        
        while(first != null){
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        showList(dummy.next);
        sc.close();
    }
    
    static void showList(Node h){
        String out = "[";
        while(h != null){
            out += h.val;
            if(h.next != null) out += ",";
            h = h.next;
        }
        out += "]";
        System.out.println(out);
    }
}
