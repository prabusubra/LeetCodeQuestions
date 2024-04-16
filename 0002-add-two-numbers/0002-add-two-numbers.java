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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //l1 = reverse(l1);
        //l2 = reverse(l2);
        //no need to reverse because we start add operation from 1's, 10's, 100's position
        
        ListNode result = null, head = null;
        int remainder = 0;
        while (l1 !=null || l2 != null){
            if (l1 == null) l1 = new ListNode(0);
            else if (l2 == null) l2 = new ListNode(0);
           // System.out.println("l1 : "+l1.val+ " l2 : "+l2.val);
            if (result == null){
                result = new ListNode((l1.val+l2.val)%10);
                head = result;
                remainder = (l1.val+l2.val)/10;
                //System.out.println("remainder 1 : "+remainder);
            } else {
                int tmp = l1.val+l2.val;
                if (remainder >0) {
                    tmp+= remainder;
                }
                //System.out.println("l1 : "+l1.val+ " l2 : "+l2.val + " val : "+tmp%10);
                result.next = new ListNode(tmp%10);
                result = result.next;
                remainder = (tmp)/10;
                //System.out.println("remainder : "+remainder);;
            }
                l1 = l1.next;
                l2 = l2.next;
        }
        if (remainder > 0) result.next = new ListNode(remainder);
        return head;
    }
}