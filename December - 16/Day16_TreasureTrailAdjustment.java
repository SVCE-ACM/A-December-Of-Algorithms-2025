import java.util.*;

public class Day16_TreasureTrailAdjustment {
    static class ListNode{int val; ListNode next; ListNode(int v){val=v;}} 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); ListNode dummy=new ListNode(0); ListNode cur=dummy; for(int i=0;i<n;i++){cur.next=new ListNode(sc.nextInt());cur=cur.next;} int pos=sc.nextInt();
        ListNode head=dummy.next; ListNode fast=head, slow=dummy;
        for(int i=0;i<pos;i++) fast=fast.next;
        while(fast!=null){fast=fast.next; slow=slow.next;}
        slow.next = slow.next!=null? slow.next.next : null;
        ListNode p=dummy.next; StringJoiner sj=new StringJoiner(" "); while(p!=null){sj.add(String.valueOf(p.val)); p=p.next;} System.out.println(sj.toString()); sc.close();
    }
}
