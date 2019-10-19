package com.company.leetcode;
/**
 * Merge Two Sorted List
 */
public class leetcode21 {
    
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }


class Solution21 {
    public ListNode cur, result;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                if(cur == null) {
                    cur = new ListNode(l1.val);
                    result = cur;
                }
                else {
                    cur.next = new ListNode(l1.val);
                    cur = cur.next;
                }
                
                l1 = l1.next;
            }
            else
            {
                if(cur == null) {
                    cur = new ListNode(l2.val);
                    result = cur;
                }
                else {
                    cur.next = new ListNode(l2.val);
                    cur = cur.next;
                }
                
                l2 = l2.next;
            }
        }
        
        while(l1 != null) {
            if(cur == null) {
                cur = new ListNode(l1.val);
                result = cur;
            }
            else {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
            }
            l1 = l1.next;
        }
        while(l2 != null) {
            if(cur == null) {
                cur = new ListNode(l2.val);
                result = cur;
            }
            else {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
            }
            l2 = l2.next;
        }
        
        return result;
    }
}
*/