package com.company.leetcode;

public class leetcode148 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
class Solution {
    public ListNode sortList(ListNode head) {
        
        return divide(head);
    }
    public ListNode divide(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode left = divide(head);
        ListNode right = divide(slow);
        
        return merge(left, right);
        
    }
    public ListNode merge(ListNode left, ListNode right) {
        if(left == null) return right;
        if(right == null) return left;
        
        
        if(left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        }
        else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}

 */
