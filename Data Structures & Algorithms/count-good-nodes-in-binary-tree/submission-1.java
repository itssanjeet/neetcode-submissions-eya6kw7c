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
    int res = 0;
    public int goodNodes(TreeNode root) {

        solve(root, Integer.MIN_VALUE);

        return res;
    }

    private void solve(TreeNode root, int val){
        if(root == null){
            return;
        }

        if(root.val >= val){
            res++;
            val = root.val;
        }

        solve(root.left, val);
        solve(root.right, val);
    }
}
