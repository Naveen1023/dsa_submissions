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
    static int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0;
        solve(root);

        return maxDia;
    }

    private int solve(TreeNode node) {

        // leaf node
        if(node.left == null && node.right == null) return 1; 


        int leftHeight = (node.left == null) ? 0 : solve(node.left);
        int rightHeight = (node.right == null) ? 0 : solve(node.right);


        // System.out.println("node.val : "+node.val+", leftH : "+leftHeight+", rightHeight : "+rightHeight+" curr path length : "+(leftHeight + rightHeight));

        maxDia = Math.max(maxDia, leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/*
at every node: 
    leftHeight = 2;
    rightHeight = 1;
    currDiameter = 2 + 1 = 3

    return max(leftHeight, rightHeight)
*/
