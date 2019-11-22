/**
 * Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * e.g.
 * IN: 1 --> 2                  OUT: false
 * IN: 1 --> 2 --> 2 --> 1      OUT: true
 *
 * Complexity: O(n) time and space
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromeLL {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public boolean isPalindromeLL(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) { return false; }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.print(new PalindromeLL().isPalindromeLL(node1));
    }
}
