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

    

    public List<List<Integer>> levelOrder(TreeNode root) {  

        List<List<Integer>> res = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            // for each level, go through current queue
            int n = queue.size();
            for(int i = 0; i < n; i++){ 
                TreeNode del = queue.remove();
                if(del != null){
                    level.add(del.val);
                    queue.add(del.left);
                    queue.add(del.right);
                }
            }

            if(level.size() > 0) res.add(level);

        }

        return res;
    }
}