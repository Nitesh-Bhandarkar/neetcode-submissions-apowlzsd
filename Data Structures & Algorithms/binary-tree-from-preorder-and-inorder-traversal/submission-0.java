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
    private TreeNode getTree(int[] preorder, int[] preOrderIdx, int[] inorder, Map<Integer, Integer> idxMap, int startIdx, int endIdx){
        if(preOrderIdx[0] >= preorder.length || startIdx > endIdx){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preOrderIdx[0]]);
        int leftIdx = idxMap.get(preorder[preOrderIdx[0]]) - 1;
        int rightIdx = idxMap.get(preorder[preOrderIdx[0]]) + 1;
        preOrderIdx[0]++;
        TreeNode left = getTree(preorder, preOrderIdx, inorder, idxMap, startIdx, leftIdx);
        TreeNode right = getTree(preorder, preOrderIdx, inorder, idxMap, rightIdx, endIdx);
        root.left = left;
        root.right = right;
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            idxMap.put(inorder[i], i);
        }

        return getTree(preorder, new int[]{0}, inorder, idxMap, 0, inorder.length-1);
        
    }
}
