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
        public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        int nodeNumber = 0;

        ListNode leftNode = null;
        ListNode prevOfLeftNode = null;

        while(node != null) {
            nodeNumber++;
            if(nodeNumber == left) {
                prevOfLeftNode = prev;
                leftNode = node;
                break;
            }
            prev = node;
            node = node.next;
        }

        // System.out.println("left : "+leftNode.val+", nodeNumber: "+nodeNumber+", prevOfLeftNode : "+prevOfLeftNode.val);

        while(node != null) {
            if(nodeNumber < left || nodeNumber > right) break;
            // System.out.println("node : "+node.val+" is reversed...., nodeNumber"+nodeNumber);
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;

            nodeNumber++;
        }

        // System.out.println("node : "+node.val+", nodeNumber: "+nodeNumber+", prev : "+prev.val);
        
        
        // prev is at right node node.
        leftNode.next = node;
        prevOfLeftNode.next = prev;

        return dummy.next;
    }
}
/*
-1 -> 1 -> 2 -> 3 <- 4 <- 5 -> 6 -> 7
      l


left.next = tp.next (3 -> 6)
pl.next = tempPrev


*/