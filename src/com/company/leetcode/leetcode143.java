package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode143 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Deque<Integer> de = new ArrayDeque<Integer>();
        
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
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        
        
        while(head != null)
        {
            deque.addLast(head);
            head = head.next;
        }
        
        ListNode prev = null;
        ListNode cur = null;
        while(!deque.isEmpty())
        {
            cur = deque.pollFirst();
            if(prev != null) {
                prev.next = cur;
            }
            prev = cur;
            
            if(deque.isEmpty()) continue;
            cur = deque.pollLast();
            if(prev != null) {
                prev.next = cur;
            }
            prev = cur;
            
        }
        if(cur != null) cur.next = null;
    }
}


**/
