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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0){
            return null;
        }

        if(n == 1){
            return lists[0];
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list:lists){
            minHeap.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            node = node.next;
            if(node != null){
                minHeap.offer(node);
            }
        }

        return dummy.next;
    }
}
