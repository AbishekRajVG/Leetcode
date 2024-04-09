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

    private boolean isSameTree(TreeNode x, TreeNode y) {
        if(x == null && y == null) return true;
        if(x == null || y == null) return false;
        
        if(x.val == y.val){
            return isSameTree(x.left, y.left) && isSameTree(x.right, y.right);
        }

        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // edge cases
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        
        return (isSameTree(root, subRoot))? true : isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
}