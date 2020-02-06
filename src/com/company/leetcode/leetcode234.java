package com.company.leetcode;

public class leetcode234 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode tree = null;
        
        if(fast != null) slow = slow.next;
        
        while(slow != null)
        {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = tree;
            tree = temp;
        }
        
        while(tree != null && head != null)
        {
            if(tree.val != head.val) return false;
            
            head = head.next;
            tree = tree.next;
        }
        
        return true;
    }
}
 */
