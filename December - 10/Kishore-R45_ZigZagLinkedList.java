import java.util.*;

public class ZigZagLinkedList {
    static class Node {
        int data;
        Node nxt;
        Node(int d){ data = d; nxt = null; }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        System.out.print("Enter node values: ");
        
        Node head = null, tail = null;
        for(int x=0; x<n; x++){
            Node temp = new Node(sc.nextInt());
            if(head == null){
                head = temp;
                tail = temp;
            } else {
                tail.nxt = temp;
                tail = temp;
            }
        }
        
        if(head == null || head.nxt == null){
            print(head);
            return;
        }
        
        Node slow = head, fast = head;
        while(fast.nxt != null && fast.nxt.nxt != null){
            slow = slow.nxt;
            fast = fast.nxt.nxt;
        }
        
        Node secondHalf = slow.nxt;
        slow.nxt = null;
        secondHalf = reverse(secondHalf);
        
        Node p1 = head;
        Node p2 = secondHalf;
        while(p2 != null){
            Node t1 = p1.nxt;
            Node t2 = p2.nxt;
            p1.nxt = p2;
            p2.nxt = t1;
            p1 = t1;
            p2 = t2;
        }
        
        print(head);
        sc.close();
    }
    
    static Node reverse(Node h){
        Node prev = null;
        while(h != null){
            Node tmp = h.nxt;
            h.nxt = prev;
            prev = h;
            h = tmp;
        }
        return prev;
    }
    
    static void print(Node h){
        String out = "";
        while(h != null){
            out += h.data;
            if(h.nxt != null) out += " ";
            h = h.nxt;
        }
        System.out.println(out);
    }
}
