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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return solve(root, val);
    }

    private TreeNode solve(TreeNode node, int val) {

        if(node == null) return new TreeNode(val);

        if(val < node.val) { // should be inserted in LST
            node.left = solve(node.left, val);
        }
        else if(val >= node.val) {
            node.right = solve(node.right, val);
        }
        return node;
    }
}