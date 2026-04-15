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
    private int getHeight(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left, diameter);
        int rightHeight = getHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[]{0};
        getHeight(root, diameter);
        return diameter[0];      
    }
}
