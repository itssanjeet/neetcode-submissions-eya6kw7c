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
        if(root == null){
            return true;
        }

        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});

        while(!q.isEmpty()){
            Object[] obj = q.poll();
            TreeNode node = (TreeNode) obj[0];
            int min = (int)obj[1];
            int max = (int)obj[2];

            if(node.val <= min || node.val >= max){
                return false;
            }

            if(node.left != null){
                q.add(new Object[]{node.left, min, node.val});
            }

            if(node.right != null){
                q.add(new Object[]{node.right, node.val, max});
            }
        }

        return true;
    }
}
