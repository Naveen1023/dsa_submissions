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
        if(root == null) return true;

        return solve(root) == -1 ? false : true;
    }

    private int solve(TreeNode node) {
        
        if(node.left == null && node.right == null) return 1;

        int leftH = (node.left == null) ? 0 : solve(node.left);
        int rightH =  (node.right == null) ? 0 : solve(node.right);

        if(leftH == -1 || rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        // System.out.println("node.val : "+node.val+"left: "+leftH+", rightH : "+rightH);

        return  1 + Math.max(leftH, rightH);
    }
}

/*
node : 
    leftH, rightH
*/
