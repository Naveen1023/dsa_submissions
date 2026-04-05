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
    static int nodeNumber;
    static int res;
    public int kthSmallest(TreeNode root, int k) {
        nodeNumber = 0;
        res = -1;
        solve(root, k, null);
        return res;
    }

    void solve(TreeNode node, int k, TreeNode prev) {
        if(node == null) return;

        solve(node.left, k, prev);

        // first time : to start the counter
        if(node.left == null && prev == null) { 
            nodeNumber = 0;
            prev = node;
        }
        nodeNumber++;
        if(nodeNumber == k) {
            res =  node.val;
            return;
        }
        
        solve(node.right, k, node);
    }
}



/*
1) Traverse all the nodes => put it in some array => sort the array
go to (k-1)th index.
    Time : 
        O(n) + O(nLogn) + O(1) ===> O(nlogn) 
    Space : 
        O(n) + O(n) ===> O(n)

2) inorder would be in sorted order => leftmost node is smallest
    start counter at left most node, return value at Kth node.

*/
