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
    private void goodNodeCount(TreeNode root, int maxVal, int[] counter){
        if(root == null){
            return;
        }

        if(root.val >= maxVal){
            counter[0]++;
        }

        goodNodeCount(root.left, Math.max(maxVal, root.val), counter);
        goodNodeCount(root.right, Math.max(maxVal, root.val), counter);
    }
    public int goodNodes(TreeNode root) {
        int[] counter = new int[]{0};
        goodNodeCount(root, Integer.MIN_VALUE, counter);
        return counter[0];
    }
}
