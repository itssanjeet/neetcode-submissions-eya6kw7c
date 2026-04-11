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

public class Codec {
    StringBuilder sb = new StringBuilder();
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "N";
        }

        dfs(root);

        sb.replace(sb.length()-1, sb.length(), "");
        return sb.toString();
    }

    private void dfs(TreeNode root){
        if(root == null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val= data.split(",");

        return deserializeDfs(val);
    }

    int i = 0;
    private TreeNode deserializeDfs(String[] val){
        if(i == val.length){
            return null;
        }

        if(val[i].equals("N")){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val[i++]));
        node.left = deserializeDfs(val);
        node.right = deserializeDfs(val);
        return node;
    }
}
