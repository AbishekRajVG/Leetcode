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
        
        int count = 0;
        ListNode node = head;
        ListNode prev = null;
        Map<ListNode, ListNode> backTrack = new HashMap<ListNode, ListNode>();

        while(node!= null){
            backTrack.put(node, prev);
            prev = node;
            node = node.next;
        }

        // mark last node
        node = prev;

        if(backTrack.get(node) == null) return null;
        
        while(n > 0){
            n--;
            node = backTrack.get(node);
        }

        if (node != null)
            node.next = node.next.next;
        else
            head = head.next;

        return head;
    }
}