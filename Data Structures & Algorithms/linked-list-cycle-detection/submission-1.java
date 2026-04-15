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
    public boolean hasCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(slowNode != null && fastNode != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if(fastNode != null){
                fastNode = fastNode.next;
                if(slowNode == fastNode){
                    return true;
                }
            }

        }

        return false;
    }
}
