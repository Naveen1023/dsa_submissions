/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-101);
        ListNode head = node;
        ListNode n1 = list1, n2 = list2;

        while(n1 != null && n2 != null) {
            if(n1.val <= n2.val) {
                node.next = n1;
                n1=n1.next;
            }
            else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }

        if(n1!=null) node.next = n1;
        if(n2 != null) node.next = n2;

        return head.next;
    }
}

/*
1->2->4
n1
1->3->5
n2
*/