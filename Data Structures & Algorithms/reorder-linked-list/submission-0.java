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
    public void reorderList(ListNode head1) {
        ListNode middleNode = getMiddleAndTrimHalf(head1);

        // System.out.println("middle of the orginal list : "+middleNode.val);

        ListNode head2 = reverseList(middleNode);

        // System.out.println("head of the reversed list : "+head2.val);
        
        mergeLists(head1, head2);
    }

    private ListNode getMiddleAndTrimHalf(ListNode node) {
        if(node.next == null) return node;
        ListNode slow = node, fast = node, prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null) { // even length, 
            prev.next = null;
            return slow;
        }
        
        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }

    private ListNode reverseList(ListNode node) {
        /*
            1 2,3,4,5
        */
        ListNode prev = null;

        while(node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }

    private void mergeLists(ListNode node1, ListNode node2) {
        /*
            1,2,3
            4,5

        */

        while(node1 != null && node2 != null) {
            ListNode nextNode1 = node1.next;
            ListNode nextNode2 = node2.next;
            
            node1.next = node2;
            node2.next = nextNode1;

            node1 = nextNode1;
            node2 = nextNode2;
        }
    }
}

/*
1,2,3,4,5
1,2,3
4,5
middle : 4
1,2,3,4,5,6
App-1 : 
    a. Create another list which is complete reverse. count #nodes at the same time.
    b. Now traverse both lists parallely : 
        1 -> 4 -> 2 -> 3 -> 4
         -> 3 -> 2 -> 1

        i, j node
        nextJ = j.next;
        i.next = j;
        j.next = i.next;  

        i = j
        j = nextJ;
        
App-2 : 
    1. find middle of the list : 
        odd length : slow is at exact middle -> we want the part after that middle
        even length : slow pointer would be at 2nd half only. 

    2. reverse the second half
    3. keep pointers at start of both first and second half
    4. traverse and keep on adding node from second half in between two nodes of first half.

    O(n) time, O(1) space
*/
