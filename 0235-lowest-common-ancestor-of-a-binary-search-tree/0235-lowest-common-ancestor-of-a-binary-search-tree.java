/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // main idea - the split or pivot will be the least common ancesstor
        return ((root.val == p.val || root.val == q.val) || (p.val < root.val ^ q.val < root.val))? root : (p.val < root.val && q.val < root.val)? lowestCommonAncestor(root.left, p, q): lowestCommonAncestor(root.right, p, q);
    }
}