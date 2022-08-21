// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approach

// We loop through the lists 
// For each list we check each node and based on which is less we place them in the list

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode dummy = null;
        for (ListNode list : lists) {
            dummy = merge(dummy, list);
        }
        return dummy;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null)
            curr.next = l2;

        return dummy.next;
    }
}

// Time Complexity : O(nklog(nk))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approach

// Made use of the priority queue
// we loop through the lists and add them to the pq
// then we poll the pq and see if the polled list has next if yes we add it to
// the pq and repeat the process
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            if (min.next != null) {
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}