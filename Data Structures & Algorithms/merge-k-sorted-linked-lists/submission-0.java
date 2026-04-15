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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(int i=0; i<lists.length; i++){
            pq.offer(lists[i]);
        }

        ListNode result = new ListNode(-1);
        ListNode currNode = result;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            currNode.next = new ListNode(node.val);
            if(node.next != null){
                pq.offer(node.next);
            }
            currNode = currNode.next;
        }

        return result.next;
    }
}
