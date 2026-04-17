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
    private void traverse(TreeNode root, int k, int[] result){
        if(root == null){
            return;
        }

        if(result[1] != -1){
            return;
        }

        traverse(root.left, k, result);
        result[0]++;
        if(result[0] == k){
            result[1] = root.val;
            return;
        }
        traverse(root.right, k, result);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[]{0, -1};
        traverse(root, k, result);
        return result[1];
    }
}
