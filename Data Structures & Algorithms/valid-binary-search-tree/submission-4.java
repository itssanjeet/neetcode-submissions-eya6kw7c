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
    public boolean isValidBST(TreeNode root) {
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean solve(TreeNode node, int lower, int upper){
        if(node == null){
            return true;
        }

        if(node.val <= lower || node.val >= upper){
            return false;
        }

        return solve(node.left, lower, node.val)
                && solve(node.right, node.val, upper);
    }
}
