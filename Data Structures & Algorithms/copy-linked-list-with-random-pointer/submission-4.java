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
        if(head == null){
            return null;
        }

        Node currNode = head;
        Map<Node, Node> map = new HashMap<>();

        while(currNode != null){
            Node copyNode = new Node(currNode.val);
            map.put(currNode, copyNode);
            currNode = currNode.next;
        }

        currNode = head;
        while(currNode != null){
            Node node = map.get(currNode);
            if(currNode.random != null){   
                node.random = map.get(currNode.random);
            }
            if(currNode.next != null) {
                node.next = map.get(currNode.next);
            }
            currNode = currNode.next;
        }

        return map.get(head);  
    }
}
