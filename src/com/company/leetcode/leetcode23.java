package com.company.leetcode;

public class leetcode23 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0 || lists == null) return null;
        return solve(lists, 0, lists.length - 1);
        
    }
    public ListNode solve(ListNode[] lists ,int s, int e)
    {
        int mid = 0;
        
        if(s == e) return lists[s];
        mid = (s + e) >> 1;
        ListNode l1 = solve(lists, s, mid);
        ListNode l2 = solve(lists, mid+1, e);
        
        return merge(l1, l2);    
    }
    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            }
            else {
                
                
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
            }
        }
        
        while(l1 != null)
        {
            result.next = new ListNode(l1.val);
            result = result.next;
            l1 = l1.next;
        }
        
        while(l2 != null)
        {

            result.next = new ListNode(l2.val);
            result = result.next;
            l2 = l2.next;
        }
        
        return cur.next;
    }
}
*/











