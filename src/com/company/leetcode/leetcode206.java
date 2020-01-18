package com.company.leetcode;

public class leetcode206 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node node = new Node();
        
        
    }
    static class Node {
        Node next;
    }
}
/**
 * /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode answer = null, prev = null;
        
        while(head != null)
        {
            int num = head.val;
            
            ListNode newNode = new ListNode(num);
            newNode.next = prev;
            prev = newNode;
            
            head = head.next;
        }
        
        
        return prev;
    }
}
 */