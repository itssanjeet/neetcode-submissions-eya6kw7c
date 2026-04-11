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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy, temp2 = dummy;

        for(int i=0; i<=n && temp2 != null; i++){
            temp2 = temp2.next;
        }

        while(temp2 != null){
            temp = temp.next;
            temp2 = temp2.next;
        }

        if(temp != null && temp.next != null){
            temp.next = temp.next.next;
        } else {
            temp.next = null;
        }

        return dummy.next;
    }
}
