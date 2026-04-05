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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return solve(root);
    }

    private boolean solve(TreeNode node) {

        if(node == null) return true;

        // if(prev!=null )
        //     System.out.println("node : "+node.val+", prev : "+prev.val);

        boolean left = solve(node.left);
        if(prev != null && node.val <= prev.val) return false;
        prev = node;
        boolean right = solve(node.right);

        if(!left || !right) return false;

        return true;
    }
}
/*
1) take inOrder => should be in ascending order O(n) time + O(n) space

2) Take inOrder => currElement should be greater than previous element. if at any time if fails => return FALSE;

*/