package com.company.leetcode;

public class leetcode876 {
    
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
    public List<ListNode> list = new ArrayList<>();
    public ListNode middleNode(ListNode head) {
        
        if(head == null) return null;
        search(head);
        int len = list.size(), index = 0;
        if(len % 2 == 0) {
            index = len + 1 >> 1;
        }
        else {
            index = len  >> 1;
        }
        
        return list.get(index);
    }
    public void search(ListNode head)
    {
        if(head == null) return;
        
        list.add(head);
        search(head.next);
    }
} 
 */
