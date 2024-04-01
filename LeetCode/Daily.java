package LeetCode;

import java.util.Stack;

public class Daily {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head2 = new ListNode(1, new ListNode(2));
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
        System.out.println(solution.isPalindrome(head2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        
        Stack<Integer> stack = new Stack<>();
        stack.add(slow.val);
        while (slow.next != null && fast.next.next != null) {
            stack.add(slow.next.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        while (!stack.isEmpty()) {

            Integer listVal = stack.pop();
            System.out.println(listVal + " " + slow.val);
            if (slow.val != listVal) {
                return false;
            }
            slow = slow.next;
        }
        return true;
        
    }
}