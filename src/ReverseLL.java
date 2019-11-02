/**
 * Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * e.g.
 * IN: 1->2->3->4->5->NULL          OUT: 5->4->3->2->1->NULL
 *
 * Complexity: O(n) time and O(1) space
 */

public class ReverseLL {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = new ReverseLL().reverseLL(node1);
        System.out.println(result.val +" -> " + result.next.val + " -> " + result.next.next.val + " -> "
                + result.next.next.next.val + " -> " + result.next.next.next.next.val + " -> NULL");
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;                                 // return new head reference
    }
}


/**
 * Recursive approach
 *
 * public ListNode reverseLL(ListNode head) {
 *     if (head == null || head.next == null) return head;
 *
 *     ListNode p = reverseLL(head.next);
 *     head.next.next = head;
 *     head.next = null;
 *     return p;
 * }
 *
 *  Complexity: O(n) time and space
 */