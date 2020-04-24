package com.company.leetcode;

public class leetcode {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
class NumArray {

    int[] tree;
    int start, end, len;
    public NumArray(int[] nums) {
        int len = nums.length;
        tree = new int[len*4];
        start = 1;
        while(len > start) start *= 2;
        end = start + len - 1;
        
        for(int i=start; i<= end; i++) {
            tree[i] = nums[i - start];
        }
        
        for(int i = end/2; i>= 1; i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }
        
    }
    
    public void update(int i, int val) {
        int dx = i + start;
        tree[dx] = val;
        while(dx > 1) { 
            dx /= 2;
            tree[dx] = tree[dx*2] + tree[dx*2+1];
        }
        
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        int dx = i + start;
        int dy = j + start;
        
        while(dx <= dy) {
            
            if(dx % 2 != 0) sum += tree[dx];
            if(dy % 2 == 0) sum += tree[dy];
            
            dx = (dx+1) / 2;
            dy = (dy-1) / 2;
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */ 
 
