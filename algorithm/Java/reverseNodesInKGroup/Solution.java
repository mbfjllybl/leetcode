package Java.reverseNodesInKGroup;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (true) {
            ListNode tmp = cur;
            for (int i = 0; i < k && tmp != null; i++) tmp = tmp.next;
            if (tmp == null) break;

            ListNode last = tmp, next = tmp.next, first = cur.next;
            tmp = first.next;
            ListNode q = first;
            for (int i = 0; i < k - 1; i++) {
                ListNode p = tmp.next;
                tmp.next = q;
                q = tmp;
                tmp = p;
            }
            first.next = next;
            cur.next = last;
            cur = first;
        }
        return dummy.next;
    }
}