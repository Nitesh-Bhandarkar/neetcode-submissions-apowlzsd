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
    private int goodNodeCount(TreeNode root, int maxVal){
        if (root == null) return 0;
        if (root.val >= maxVal)
            return 1 + goodNodeCount(root.left, root.val) + goodNodeCount(root.right, root.val);
        else
            return goodNodeCount(root.left, maxVal) + goodNodeCount(root.right, maxVal);
    }
    public int goodNodes(TreeNode root) {
        // int[] counter = new int[]{0};
        return goodNodeCount(root, Integer.MIN_VALUE);
        // return counter[0];
    }
}
