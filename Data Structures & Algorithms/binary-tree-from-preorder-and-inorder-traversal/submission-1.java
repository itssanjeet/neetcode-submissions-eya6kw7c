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

    int index = 0;
    Map<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }

        return solve(preorder, 0, preorder.length-1);
    }

    private TreeNode solve(int[] preorder, int l, int r){
        
        if(l>r)return null;

        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        
        int mid = hm.get(val);
        root.left = solve(preorder, l, mid-1);
        root.right = solve(preorder, mid+1, r);

        return root;
    }
}
