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
            return "";
        }

        encode(root);

        return sb.toString();
    }

    private void encode(TreeNode root){
        if(root == null){
            sb.append("N").append(";");
            return;
        }

        sb.append(root.val).append(";");
        encode(root.left);
        encode(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }

        String[] str = data.split(";");

        return decode(str);
    }

    int idx = 0;
    private TreeNode decode(String[] str){
        if(idx == str.length){
            return null;
        }

        String strVal = str[idx++];
        if(strVal.equals("N")){
            return null;
        }

        int val = Integer.parseInt(strVal);
        TreeNode node = new TreeNode(val);
        node.left = decode(str);
        node.right = decode(str);

        return node;
    }
}
