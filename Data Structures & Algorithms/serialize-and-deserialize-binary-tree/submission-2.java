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

        inorder(root);
        System.out.println(sb.toString());

        return sb.toString();
    }

    private void inorder(TreeNode root){
        if(root == null){
            sb.append("N").append(";");
            return;
        }

        sb.append(root.val).append(";");
        inorder(root.left);
        inorder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }

        String[] str = data.split(";");
        if(str.length == 0){
            return null;
        }

        return decode(str);
    }

    int i=0;
    private TreeNode decode(String[] str){
        if(i == str.length){
            return null;
        }

        if(str[i].equals("N")){
            i++;
            return null;
        }

        int val = Integer.parseInt(str[i++]);
        TreeNode root = new TreeNode(val);
        root.left = decode(str);
        root.right = decode(str);

        return root;
    }
}
