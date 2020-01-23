package com.company.leetcode;

public class leetcode48 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[][] nums;
    public void rotate(int[][] matrix) {
        
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        nums = matrix;
        
        for(int i= 0; i< row; i++)
        {
            for(int j=i ; j< col; j++)
            {
                swap(i, j, j, i);
            }
        }
        
        for(int i= 0; i< row; i++)
        {
            int s=0, e = col-1;
            while(s < e) {
                swap(i, s, i, e);
                s++; e--;
            }
        }
    }
    public void swap(int dx1, int dy1, int dx2, int dy2)
    {
        int temp = nums[dx1][dy1];
        nums[dx1][dy1] = nums[dx2][dy2];
        nums[dx2][dy2] = temp;
    }
}
 */
