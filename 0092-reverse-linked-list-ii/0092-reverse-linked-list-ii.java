/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fwd = null;

        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode dummy3 = new ListNode(-1);

        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        ListNode t3 = dummy3;

        ListNode temp = head;

        for (int i = 1; i < left; i++) {
            ListNode next = temp.next;
            temp.next = null;
            t1.next = temp;
            t1 = t1.next;
            temp = next;
        }

        for (int i = left; i <= right; i++) {
            ListNode next = temp.next;
            temp.next = null;
            t2.next = temp;
            t2 = t2.next;
            temp = next;
        }

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = null;
            t3.next = temp;
            t3 = t3.next;
            temp = next;
        }

        ListNode revHead = reverse(dummy2.next);

        if (dummy1.next == null) {
            dummy1.next = revHead;
        } else {
            t1.next = revHead;
        }

        ListNode tail = revHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = dummy3.next;

        return dummy1.next;
    }
}