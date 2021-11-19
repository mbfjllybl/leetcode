package Java.rotateList;

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
    public ListNode rotateRight(ListNode head, int k) {
        int cnt = 0;
        ListNode dummy = new ListNode(0, head), p = dummy;
        while (p.next != null) {
            p = p.next;
            cnt++;
        }
        if (cnt == 0) return dummy.next;
        k %= cnt;
        ListNode q = dummy;
        for (int i = 0; i < cnt - k; i++) {
            q = q.next;
        }
        p.next = dummy.next;
        dummy.next = q.next;
        q.next = null;
        return dummy.next;
    }
}