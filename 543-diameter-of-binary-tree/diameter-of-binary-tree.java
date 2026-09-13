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

    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        height(root);
        return diameter;
    }
    private int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);

        //Calculating the Diameter
        diameter=Math.max(diameter,leftHeight+rightHeight);

        //Returning the node
        return 1+Math.max(leftHeight,rightHeight);
    }
}