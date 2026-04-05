/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = null;

        // create new nodes....
        Node temp = head;
        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        newHead = map.get(head); // we have newHead set to correct node now

        temp = head;

        while(temp != null) {
            Node newNode= map.get(temp);
            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return newHead;
    }
}
/*
- duplicate all the nodes, put them in hashmap <node, new_node>
- iterate and replicate the pointers

*/