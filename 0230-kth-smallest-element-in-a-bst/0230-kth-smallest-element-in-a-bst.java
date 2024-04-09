/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();
        // List<Integer> inorder = new ArrayList<>();

        int count = 0;

        TreeNode node = root;
        do{            
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(count == k - 1) {
                return node.val;
            }
            else count++;
            node = node.right;

        }while(node != null || !stack.isEmpty());

        return -1;

    }
}