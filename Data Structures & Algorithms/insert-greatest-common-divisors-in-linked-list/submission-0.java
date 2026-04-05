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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head;
        if(head.next == null) return head;
        ListNode node = head.next;

        while(node != null) {
            int gcd = findGcd(prev.val, node.val);
            ListNode gcdNode = new ListNode(gcd);
            gcdNode.next = node;
            prev.next = gcdNode;
            prev = node;
            node = node.next;
        }
        return head;
    }
    private int findGcd(int a, int b) {
        if(a == 1 || b == 1) return 1;

        if(a < b) return findGcd(b,a);

        if(a % b == 0) return b;
        else return findGcd(a%b, b);
    }
}
/*
12 -> 3 -> 4 -> 6

gcd(12,3) = 3
gcd(3,4) = 1
gcd(4,6) = 2

(n-1) pairs, each takes O(m) => O(m*n)



*/




