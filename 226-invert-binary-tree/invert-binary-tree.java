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
    public TreeNode invertTree(TreeNode root) {
        
        if(root==null){
            return null;
        }
        //Using the brute approach method values
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        //Swapping the values of the subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}