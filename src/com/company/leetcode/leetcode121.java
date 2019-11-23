package com.company.leetcode;

public class leetcode121 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
class Solution {
    public int len, start, end, answer;
    public int[] tree;
    public int maxProfit(int[] prices) {
        len = prices.length;
        tree = new int[4*len];
        start = 1; answer = 0;
        while(len > start) start = start << 1;
        end = start + len;
        
        for(int i=1; i< (len*4) -1; i++) tree[i] = Integer.MAX_VALUE;
        
        for(int i=1; i<= len; i++)
        {
            int target = prices[i-1];
            if(i != 1)
            {
                if(target - tree[1] > 0)
                {
                    answer = max(answer, target - tree[1]);
                }
            }
            update(i, target);
        }
        
        return answer;
    }
    public void update(int sdx, int num)
    {
        int dx = start + sdx - 1;
        tree[dx] = num;
        while(dx > 1)
        {
            dx /= 2;
            int left = tree[dx*2];
            int right = tree[dx*2+1];
            tree[dx] = min(left, right);
        }
    }
    public int min(int a, int b) { return a > b ? b : a;}
    public int max(int a, int b) { return a > b ? a : b ;}
}
 */
