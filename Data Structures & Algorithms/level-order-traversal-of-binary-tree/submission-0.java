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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Queue<TreeNode> q2 = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                
                list.add(node.val);
                if(node.left != null){
                    q2.add(node.left);
                }

                if(node.right != null){
                    q2.add(node.right);
                }
            }

            res.add(list);
            while(!q2.isEmpty()){
                q.add(q2.poll());
            }
        }

        return res;
    }
}
