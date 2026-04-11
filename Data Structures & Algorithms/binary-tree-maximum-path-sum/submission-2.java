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
    int res;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        res = root.val;

        dfs(root);

        return res;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);
        
        res = Math.max(res, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
