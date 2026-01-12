import java.util.Scanner;
class ListNode{
    int value;
    ListNode next;
    ListNode(int value){
        this.value = value;
    }
}
public class MonishmakerZigzag{
    public static void zigZag(ListNode head){
        if(head==null||head.next==null) return;

        ListNode slow = head, fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        ListNode first = head;
        second = prev;
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        
    }
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N:");
        int n = sc.nextInt();

        System.out.print("Enter node values: ");
        ListNode head = null , tail = null;
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            ListNode node = new ListNode(val);
            if(head==null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail= node;
            }
        }
        zigZag(head);
        printList(head);
    }
}