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
    public int diameterOfBinaryTree(TreeNode root) {     
        solve(root);   
        return res;
    }

    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);

        res = Math.max(leftHeight + rightHeight, res);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
