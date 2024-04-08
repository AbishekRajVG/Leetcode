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
    public void reorderList(ListNode head) {

        ListNode iter = head;
        Stack<ListNode> stack = new Stack<ListNode>();

        while(iter != null){
            stack.push(iter); // push temp reference to a buffer stack 
            iter = iter.next;
        }

        ListNode node = head;
        ListNode stackNode = null;

        while(node != null){
            stackNode = stack.pop();
            stackNode.next = (stackNode == node.next)? null: node.next;
            node.next = (node == stackNode)? null: stackNode;
            node = stackNode.next;
        }

    }

}