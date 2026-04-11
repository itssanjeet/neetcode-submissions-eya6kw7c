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

        solve(root, root.val);

        return res;
    }

    private void solve(TreeNode root, int good){
        if(root == null){
            return;
        }

        if(root.val >= good){
            res++;
            good = root.val; 
        }

        solve(root.left, good);
        solve(root.right, good);
    }
}
