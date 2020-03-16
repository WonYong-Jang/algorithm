package com.company.leetcode;
/**
 *
 */
public class leetcode2 {
    
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
/**
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        
        int carry = 0;
        while(l1 != null || l2 != null) {
            
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            
            ListNode tmp = new ListNode( (num1 + num2 + carry) % 10);
            curr.next = tmp;
            curr = curr.next;
            if(num1 + num2 + carry > 9) carry = 1;
            else carry = 0;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry == 1) curr.next = new ListNode(1);
            
        return ans.next;
    }
} 
 */
