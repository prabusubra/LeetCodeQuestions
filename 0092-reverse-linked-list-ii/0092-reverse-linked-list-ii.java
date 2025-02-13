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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(0, head);

        //marker
        ListNode leftprev = dummy;
        ListNode curr = head;

        for (int i=0; i < left -1; i++ ) {
            leftprev = leftprev.next;
            curr = curr.next;
        }

        //reverse start
        ListNode revstart = curr, prev = null, next = null;

        for (int i=0; i < right - left +1; i++ ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //reconnecting
        leftprev.next = prev;
        revstart.next = curr;

        return dummy.next;
    }
    
}

/**
* Time Complexity: \U0001d442(\U0001d45b) O(n) (Single traversal of the list)
* Space Complexity: \U0001d442(1) O(1) (In-place operation with constant extra space) 
*/