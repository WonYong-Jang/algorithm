package com.company.leetcode;
/**
 *  Maximum Sum of 3 Non-Overlapping Subarrays
 */
public class leetcode689 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}

/**
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        
        if( (len == 0) || (len < k*3) ) return new int[]{-1, -1, -1};
        
        int a = 0, b = 0, c = 0, sumA = 0, sumB = 0, sumC = 0;
        int maxA = 0, maxAB = 0, maxABC = 0;
        int windowA = 0;
        int[] windowAB = new int[2];
        int[] windowABC = new int[3];
        
        b = k;
        c = k*2;
        windowAB[1] = b;
        windowABC[1] = b; windowABC[2] = c;
        
        
        for(int i=a; i< a+k; i++) sumA += nums[i];
        for(int i=b; i< b+k; i++) sumB += nums[i];
        for(int i=c; i< c+k; i++) sumC += nums[i];
        
        maxA = sumA;
        maxAB = maxA + sumB;
        maxABC = maxAB + sumC;
        
        while( c+k < len)
        {
            a += 1;         
            b += 1;
            c += 1;
            sumA = sumA - nums[a-1] + nums[a+k-1];
            sumB = sumB - nums[b-1] + nums[b+k-1];
            sumC = sumC - nums[c-1] + nums[c+k-1];
            
            if(sumA > maxA) 
            {
                maxA = sumA;
                windowA = a;
            }
            if(maxAB < maxA + sumB)
            {
                maxAB = maxA + sumB;
                windowAB[0] = windowA;
                windowAB[1] = b;
            }
            if(maxABC < maxAB + sumC)
            {
                maxABC = maxAB + sumC;
                windowABC[0] = windowAB[0];
                windowABC[1] = windowAB[1];
                windowABC[2] = c;
            }
            
        }
        
        return windowABC;
    }
}
 */
