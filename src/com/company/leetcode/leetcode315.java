package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode315 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/**
import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return ans;
        else if( len == 1) return new ArrayList<>(Arrays.asList(0));
        
        ans.add(0);
        Node root = new Node(nums[len-1], 1);
        
        for(int i = len-2; i >=0 ; i--) {
            int target = nums[i];
            
            Node start = root;
            int cnt = 0;
            while(start != null) { 
                Node tmp = new Node(target, 1);
                
                if(start.val < target) { // right
                    cnt += start.NumOfLeft;
                    if(start.right == null) {
                        start.right = tmp;
                        break;
                    }
                    start = start.right;
                }
                else { // left
                    int num = start.NumOfLeft;
                    start.NumOfLeft = num+1;
                    if(start.left == null) {
                        start.left = tmp;
                        break;
                    }
                    start = start.left;
                }
            }
            ans.add(cnt);
        }
        
        
        Collections.reverse(ans);
        return ans;
    }
    class Node {
        Node left;
        Node right;
        int val, NumOfLeft;
        Node(int a, int b) { 
            val = a; NumOfLeft = b;
        }
    }
} 
 */
