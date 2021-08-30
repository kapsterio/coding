package com.zh;

public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left = l1;
        ListNode right = l2;
        ListNode result = null;
        ListNode pre = null;
        int carry = 0;
        while (left != null || right != null || carry != 0) {
            //int value = left.val + right.val + carry;
            int value = carry + ((left == null) ? 0 : left.val) + ((right == null) ? 0 : right.val);
            carry = value / 10;
            ListNode node = new ListNode(value % 10);
            if (pre != null) {
                pre.next = node;
            }
            if (result == null) {
                result = node;
            }
            pre = node;
            if (left != null) {
                left = left.next;
            }
            if (right != null) {
                right = right.next;
            }
        }
        return result;
    }
}
