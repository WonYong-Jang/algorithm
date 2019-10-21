package com.company.leetcode;

public class leetcode141 {
    
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
 
public class Solution {
   
    public boolean hasCycle(ListNode head) {
        
        if(head == null) return false;
        
        boolean result = false;
        
        ListNode hare = head;
        ListNode tortoise = head;
        
        while(true)
        {
            if(hare == null || hare.next == null) break;
            
            tortoise = tortoise.next;
            hare = hare.next.next;
            
            if(hare == tortoise) {
                result = true;
                break;
            }
            
        }
        
        return result;
    }
    
}
*/