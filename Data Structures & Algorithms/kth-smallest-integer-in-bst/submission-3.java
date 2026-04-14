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
    int res = 0, cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);

        return res;
    }

    private void solve(TreeNode root, int k){
        if(root == null){
            return;
        }

        solve(root.left, k);
        cnt++;
        if(cnt == k){
            res = root.val;
            return;
        }
        solve(root.right, k);
    }
}
