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

    Map<Integer, Integer> valIdxMap = new HashMap<>();
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        int n = inorder.length;
        for(int i=0; i<inorder.length; i++){
            valIdxMap.put(inorder[i], i);
        }

        return solve(preorder, 0, n-1);
    }

    private TreeNode solve(int[] preorder, int l, int r){
        if(l > r){
            return null;
        }

        int val = preorder[idx];
        idx++;
        int i = valIdxMap.get(val);
        TreeNode root = new TreeNode(val);
        root.left = solve(preorder, l, i-1);
        root.right = solve(preorder, i+1, r);

        return root;
    }
}





