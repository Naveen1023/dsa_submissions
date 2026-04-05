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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return solve(root, subRoot);
    }

    private boolean solve(TreeNode node, TreeNode subRoot) {
        if(node == null) return false;

        // System.out.println("CurNode : "+node.val+" validateIfSubRoot(node, subRoot) : "+validateIfSubRoot(node, subRoot));

        if(validateIfSubRoot(node, subRoot)) return true;

        return solve(node.left, subRoot) || solve(node.right, subRoot); 
    }

    private boolean validateIfSubRoot(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;

        if((p == null && q != null) || (p != null && q == null) ) return false;
        
        if(p.val != q.val) return false;

        return validateIfSubRoot(p.left, q.left) && validateIfSubRoot(p.right, q.right);
    }
}
