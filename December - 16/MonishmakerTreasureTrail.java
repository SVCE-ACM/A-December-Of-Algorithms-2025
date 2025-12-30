import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    
    ListNode(int val){
        this.val = val;
    }
}
public class MonishmakerTreasureTrail {
    public static ListNode buildList(int[] arr){
        if(arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i=1;i<arr.length;i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
    public static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i=0;i<=n;i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }
    public static void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] parts = s.split(" ");
        int[] arr = new int[parts.length];
        for(int i=0;i<parts.length;i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        int n = sc.nextInt();
        ListNode head = buildList(arr);
        ListNode modifiedHead = removeNthFromEnd(head, n);
        printList(modifiedHead);
    }
}
