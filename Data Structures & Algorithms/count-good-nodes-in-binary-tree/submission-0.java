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
    int res;
    public int goodNodes(TreeNode root) {
        res = 0;
        solve(root, Integer.MIN_VALUE);
        return res;
    }

    private void solve(TreeNode node, int maxValueOnCurrentPath) {
        if(node == null) return;

        int newMax = maxValueOnCurrentPath;

        if(node.val >= maxValueOnCurrentPath) {
            newMax = node.val;
            res++;
        }
        solve(node.left, newMax);
        solve(node.right, newMax);
    }
}
