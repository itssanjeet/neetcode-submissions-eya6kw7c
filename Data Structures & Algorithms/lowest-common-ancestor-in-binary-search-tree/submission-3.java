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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> childToParentMap = new HashMap<>();
        createMap(root, childToParentMap);

        // for(Map.Entry<Integer, TreeNode> entry: childToParentMap.entrySet()){
        //     System.out.println("Key: " + entry.getKey() + "; Val: " + entry.getValue().val);
        // }

        Set<Integer> parents = new HashSet<>();
        TreeNode temp = p;
        while(temp != null){
            parents.add(temp.val);
            temp = childToParentMap.get(temp.val);
        }

        TreeNode t1 = q;
        while(t1 != null){
            if(parents.contains(t1.val)){
                return t1;
            }

            t1 = childToParentMap.get(t1.val);
        }
        
        return t1;
    }

    private void createMap(TreeNode node, Map<Integer, TreeNode> map){
        if(node.left != null){
            map.put(node.left.val, node);
            createMap(node.left, map);
        }

        if(node.right != null){
            map.put(node.right.val, node);
            createMap(node.right, map);
        }
    }
}
