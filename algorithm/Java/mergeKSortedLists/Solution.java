package Java.mergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                if (listNode.val <= t1.val) return 1;
                else return -1;
            }
        });
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) priorityQueue.offer(lists[i]);
        }
        while (!priorityQueue.isEmpty()) {
            p.next = priorityQueue.poll();
            if (p.next.next != null) priorityQueue.offer(p.next.next);
            p = p.next;
        }
        return dummy.next;
    }
}
