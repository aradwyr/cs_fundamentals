import java.util.List;

/**
 * Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * e.g.
 * IN: (2 -> 4 -> 3) + (5 -> 6 -> 4)        OUT: 7 -> 0 -> 8            // 342 + 465 = 807.
 *
 * Complexity: O(max(m, n)) time and space where m and n are the lengths of the two linked lists
 */

public class AddTwoLL {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode result = new AddTwoLL().addTwoNumbers(node1, node2);
        System.out.print(result.val + " -> " + result.next.val + " -> " + result.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode i = l1, j = l2, curr = dummyHead;
        int carry = 0;

        while (i != null || j != null) {
            int x = (i != null) ? i.val : 0;
            int y = (j != null) ? j.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (i != null) { i = i.next; }
            if (j != null) { j = j.next; }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
