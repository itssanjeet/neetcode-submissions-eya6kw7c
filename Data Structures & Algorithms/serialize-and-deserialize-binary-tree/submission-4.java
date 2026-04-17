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

        System.out.println(sb);

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

        System.out.println(data);

        String[] str = data.split(";");

        return decode(str);
    }

    int idx = 0;
    private TreeNode decode(String[] str){
        String node = str[idx++];

        if(node.equals("N")){
            return null;
        }

        int val = Integer.parseInt(node);
        TreeNode root = new TreeNode(val);
        root.left = decode(str);
        root.right = decode(str);

        return root;
    }
}


