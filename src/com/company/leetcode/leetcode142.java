package com.company.leetcode;

/**
 * linked list cycle 2
 *
 */

public class leetcode142 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 
public class Solution142 {
    public HashSet<ListNode> set = new HashSet<>();
    public int num = 0;
    public ListNode detectCycle(ListNode head) {
        
        if(head == null) return null;
        if(set.contains(head)) return head;
        set.add(head);
        num++;
        return detectCycle(head.next);
        
    }
}

*/