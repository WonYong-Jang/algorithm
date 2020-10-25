package com.company.leetcode;

public class leetcode19 {
    
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
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
     
        return solve(head, n);
    }
    public ListNode solve(ListNode head, int n) {
        if(head == null) return null;
        
        int size = 0;
        ListNode start = head;
        while( start != null) { // 전체 길이 탐색 
            size++;
            start = start.next;
        }
        int target = size - n + 1; // 삭제할 노드번호 (앞에서 부터)
        if(target == 1) {
            head = head.next;
            return head;
        }
        
        start = head;
        ListNode prev = null;
        size = 0;
        while(start != null) {
            size++;
            
            if(size == target) { // delete 
                if(prev != null) prev.next = start.next;
                start.next = null;
                
                break;
            }
            prev = start;
            start = start.next;
        }
        
        return head;
    }
}


 
*/
