package Java.reverseLinkedListIi;

import java.nio.file.FileStore;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        int cnt = 0;
        while (p != null) {
            if (cnt == left - 1) {
                ListNode q = p.next;
                ListNode first = p.next, second = p.next.next;
                for (int i = left; i < right; i++) {
                    ListNode tmp = second.next;
                    second.next = first;
                    first = second;
                    second = tmp;
                }
                p.next = first;
                q.next = second;
                return dummy.next;
            }
            p = p.next;
            cnt++;
        }
        return null;
    }
}