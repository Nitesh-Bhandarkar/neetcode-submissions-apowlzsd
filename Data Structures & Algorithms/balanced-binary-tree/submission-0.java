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
    private int balanceCheck(TreeNode root, boolean[] result){
        if(root == null){
            return 0;
        }

        int leftHeight = balanceCheck(root.left, result);
        int rightHeight = balanceCheck(root.right, result);

        if(result[0] && Math.abs(leftHeight - rightHeight) > 1){
            result[0] = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }
    public boolean isBalanced(TreeNode root) {
        boolean[] result = new boolean[]{true};
        
        balanceCheck(root, result);
        return result[0];
    }
}
