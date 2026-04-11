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

        dfs(root);

        return sb.toString();
    }

    private void dfs(TreeNode root){
        if(root == null){
            sb.append("N").append(";");
            return;
        }

        sb.append(root.val).append(";");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }

        System.out.println(data);
        String[] str = data.split(";");
        if(str.length == 0){
            return null;
        }

        return dfs2(str);
    }

    int i = 0;
    private TreeNode dfs2(String[] str){
        if(i == str.length){
            return null;
        }

        if(str[i].equals("N")){
            i++;
            return null;
        }

        int val = Integer.parseInt(str[i++]);
        TreeNode root = new TreeNode(val);
        root.left = dfs2(str);
        root.right = dfs2(str);

        return root;
    }
}
