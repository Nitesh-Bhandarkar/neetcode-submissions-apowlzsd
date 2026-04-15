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
        ListNode fastNode = head;
        while(n > 0){
            fastNode = fastNode.next;
            n--;
        }

        ListNode currNode = head;
        ListNode prevNode = null;

        while(fastNode != null){
            prevNode = currNode;
            currNode = currNode.next;
            fastNode = fastNode.next;
        }

        if(prevNode == null){
            return head.next;
        }

        prevNode.next = currNode.next;
        return head;
    }
}
