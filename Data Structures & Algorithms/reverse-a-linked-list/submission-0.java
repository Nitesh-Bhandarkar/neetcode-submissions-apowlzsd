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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode nextNode = head.next;
        head.next = null;
        while(nextNode != null){
            ListNode tmp = nextNode.next;
            nextNode.next = null;
            nextNode.next = head;
            head = nextNode;
            nextNode = tmp;
        }

        return head;
        
    }
}
