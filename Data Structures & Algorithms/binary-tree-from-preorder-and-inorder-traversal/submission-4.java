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

    Map<Integer, Integer> pair = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0){
            return null;
        }

        for(int i=0; i<inorder.length; i++){
            pair.put(inorder[i], i);
        }

        return solve(preorder, 0, inorder.length-1);
    }

    int idx = 0;
    private TreeNode solve(int[] preorder, int l, int r){
        if(l > r){
            return null;
        }

        int val = preorder[idx++];
        int i = pair.get(val);

        TreeNode root = new TreeNode(val);
        root.left = solve(preorder, l, i-1);
        root.right = solve(preorder, i+1, r);

        return root;
    }
}
