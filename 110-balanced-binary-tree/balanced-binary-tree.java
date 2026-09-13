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
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
    private int height(TreeNode node){

        if(node==null){
            return 0;
        }
        int leftNode=height(node.left);
        if(leftNode==-1){
            return -1;
        }
        int rightNode=height(node.right);
        if(rightNode==-1){
            return -1;
        }
        if(Math.abs(leftNode-rightNode)>1){
            return -1;
        }
        return 1+Math.max(leftNode,rightNode);
    }
}