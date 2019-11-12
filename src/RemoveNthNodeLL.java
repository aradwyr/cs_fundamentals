/**
 * Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * e.g.
 * IN: 1->2->3->4->5, and n = 2         OUT:
 *
 * Note: Given n will always be valid.
 *
 * Complexity:
 * O(L) time overall -- where L is list length, 2L - n operations
 * O(1) space
 */

public class RemoveNthNodeLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = new RemoveNthNodeLL().removeNthNodeFromEnd(node1, 2);

        System.out.println(result.val +" -> " + result.next.val + " -> " + result.next.next.val + " -> "
                + result.next.next.next.val + " -> NULL");
    }

    public ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);                            // add dummy node to address corner cases, i.e. removing head of list or input LL has only 1 node
        dummy.next = head;
        int length = 0;
        ListNode first = head;

        while (first != null) {                                         // first, find the length of LL
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;                                         // while loop ends on the node right in front of the one we need to eliminate
        }
        first.next = first.next.next;                                   // skip over the node that is to be removed
        return dummy.next;
    }
}
