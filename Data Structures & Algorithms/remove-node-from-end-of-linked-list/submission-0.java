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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode prev = temp;

        for(int i=0;i<n;i++) {
            fast = fast.next;
        }

        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next; // delete nth node now
        
        return temp.next; 
    }
}
/*
App-1 : 
    traverse whole list, count and then again traverse and return.

App-2 : 
    fast pointer traverses n steps already

    1,2,3,4     , n=4
            f
    s
*/
