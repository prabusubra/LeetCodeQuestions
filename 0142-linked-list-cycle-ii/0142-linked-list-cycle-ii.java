/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode fast = head, slow = head, cyclic = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                
                ListNode slow1 = head;

                while (slow1 != fast) {
                    slow1 = slow1.next;
                    fast = fast.next;
                }
                cyclic = slow1;
                break;
                

            }
        }

        return cyclic;
    }
}