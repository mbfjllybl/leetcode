package Java.swapNodesInPairs;

import java.util.List;

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



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode l = p.next, r = p.next.next;
            l.next = r.next;
            r.next = l;
            p.next = r;
            p = p.next.next;
        }
        return dummy.next;
    }
}