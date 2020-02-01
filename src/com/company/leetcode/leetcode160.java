package com.company.leetcode;

public class leetcode160 {
    
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
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        while(curA != null && curB != null)
        {
            if(curA == curB) return curA;
            
            curA = curA.next;
            curB = curB.next;
            if(curA == null && curB == null) return null;
            if(curA == null) curA = headB;
            if(curB == null) curB = headA;
            
        }
        
        return null;
    }
}




*/

