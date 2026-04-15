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
    private ListNode reverseNode(ListNode head){
        if(head == null){
            return null;
        }

        ListNode currHead = head;
        ListNode nextNode = currHead.next;
        currHead.next = null;
        while(nextNode != null){
            ListNode tmpNode = nextNode.next;
            nextNode.next = currHead;
            currHead = nextNode;
            nextNode = tmpNode;
        }

        return currHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> headList = new ArrayList<>();
        ListNode prevNode = null;
        int count = 0;
        while(head != null){
            if(count == 0){
                headList.add(head);
            }

            prevNode = head;
            head = head.next;
            count++;
            if(count == k){
                count = 0;
                prevNode.next = null;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode currNode = result;
        for(int i=0; i<headList.size()-1; i++){
            ListNode reverseHead = reverseNode(headList.get(i));
            currNode.next = reverseHead;
            while(reverseHead != null){
                reverseHead = reverseHead.next;
                currNode = currNode.next;
            }
        }

        System.out.println(count);
        if(count != 0){
            currNode.next = headList.get(headList.size()-1);
        }
        else{
            ListNode reverseHead = reverseNode(headList.get(headList.size()-1));
            currNode.next = reverseHead;
        }

        return result.next;   
    }
}
