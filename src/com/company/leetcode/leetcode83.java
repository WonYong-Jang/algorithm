package com.company.leetcode;

import java.util.HashSet;

public class leetcode83 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashSet<Integer> set = new HashSet<>();
        
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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        
        ArrayList<ListNode> arr = new ArrayList<>();
        while(head != null) {
            
            if(!set.contains(head.val)) {
                set.add(head.val);
                arr.add(head);
            }
            head = head.next;
        }
        
        ListNode ans = null;
        ListNode prev = null;
        for(int i=0; i< arr.size(); i++) {
            ListNode cur = arr.get(i);
            if(i == 0) {
                ans = cur;
                prev = cur;
            }
            else {
                prev.next = cur;
                prev = cur;
            }
            
            if(i == arr.size() -1) prev.next = null;
        }
        
        return ans;
    }
}
*/