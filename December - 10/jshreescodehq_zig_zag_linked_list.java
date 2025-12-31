import java.util.Scanner;

public class ZigZagLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        Node head = null, tail = null;

        System.out.print("Enter node values: ");
        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            Node newNode = new Node(val);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        head = zigZag(head);

        // Print result
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }

    static Node zigZag(Node head) {
        if (head == null || head.next == null)
            return head;
       
      Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = reverse(slow.next);
        slow.next = null;

        Node first = head;
        while (second != null) {
            Node t1 = first.next;
            Node t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }

        return head;
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
