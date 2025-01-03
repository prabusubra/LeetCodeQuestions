/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        //1 -> 2 -> 2 -> 1
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = head, reversed = reverse(slow);
        while (reversed != null ) {
            
            if (curr.val != reversed.val) return false;

            curr = curr.next;
            reversed = reversed.next;

        }

        return true;
    }

    private static ListNode reverse(ListNode node) {

        ListNode prev = null, curr = node, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}