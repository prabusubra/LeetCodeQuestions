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
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k ==0) return head;

        ListNode curr = head;

        int len = 1;

        while (curr.next != null ) {
            curr = curr.next;
            len++;
        }

        curr.next = head;

        ListNode newNode = head;

        k = k % len;

        //if (k == 0) return head;

        for (int i=1; i <(len - k); i++ ) {
            newNode = newNode.next;
        }

        ListNode newHead = newNode.next;
        newNode.next = null;

        return newHead;

    }
}