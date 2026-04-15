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
    public ListNode reverseNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null;
        while(nextNode != null){
            ListNode tmpNode = nextNode.next;
            nextNode.next = null;
            nextNode.next = head;
            head = nextNode;
            
            nextNode = tmpNode;
        }

        return head;
    }
    public void reorderList(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        ListNode secondHalfNode = slowNode.next;
        slowNode.next = null;
        ListNode reverseHead = reverseNode(secondHalfNode);

        while(head != null && reverseHead != null){
            ListNode nextNode = head.next;
            head.next = reverseHead;
            reverseHead = reverseHead.next;
            head.next.next = nextNode;
            head = nextNode;    
        }

        if(reverseHead!=null){
            head.next = reverseHead;
        }

        
    }
}
