/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> nodeToCopy = new HashMap<>();

        Node temp = head;
        while(temp != null){
            Node copy = new Node(temp.val);
            nodeToCopy.put(temp, copy);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node copy = nodeToCopy.get(temp);
            copy.next = nodeToCopy.get(temp.next);
            copy.random = nodeToCopy.get(temp.random);
            temp = temp.next;
        }

        return nodeToCopy.get(head);
    }

    
}
