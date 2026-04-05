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
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        solve(root, p, q);
        return res;
    }

    private TreeNode solve(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return null;

    
        TreeNode left = solve(node.left, p, q);
        TreeNode right = solve(node.right, p , q);

        int leftVal = (left == null) ? -1 : left.val;
        int rightVal = (right == null) ? -1 : right.val;

        // System.out.println("node.val : "+node.val+"left : "+leftVal+", right : "+rightVal);

        if(left != null && right != null) { // one is in LST, one is in RST
            res = node;
            return node;
        }

        if(left == null && right != null) { // one is in RST, check is current node is the second one
            if(node.val == p.val || node.val == q.val) {
                res = node;
                return node;
            }
            return right;
        }
        if(right == null && left != null) { // one is in LST, check is current node is the second one
            if(node.val == p.val || node.val == q.val) {
                res = node;
                return node;
            }
            return left;
        }

        // case of both left and right null
        if(left == null && right == null) {
            if (node.val == p.val || node.val == q.val) return node;
        }
        return null;
    }
}
