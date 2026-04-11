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
        ListNode dummy = new ListNode();

        int carry = 0;
        ListNode curr = dummy;
        while(l1 != null || l2 != null){
            int val = carry;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }

            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
