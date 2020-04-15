package com.company.leetcode;

public class leetcode179 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public String largestNumber(int[] nums) {
        
        PriorityQueue<String> que = new PriorityQueue<>(new mySort());
        int len = nums.length;
        for(int i=0; i< len; i++) {
            String str = Integer.toString(nums[i]);
            que.add(str);
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(!que.isEmpty()) {
            String cur = que.poll();
            if(index == 0 && cur.equals("0")) continue;
            sb.append(cur);
            index++;
        }
        
        if(sb.length() > 0) return sb.toString();
        else return "0";
    }
    public class mySort implements Comparator<String> {
        public int compare(String a, String b) {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        }
    }
} 
 */
