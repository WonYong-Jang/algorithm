package com.company.leetcode;

import java.util.Comparator;

public class leetcode1029 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] map = new int[5][2];
        
        Comparator<int[]> mySort = new Comparator<int[]>() {
            
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return 0;
            }
            
        };
    }
    
}
/**
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> {
            return Math.abs(b[0]-b[1]) - Math.abs(a[0]-a[1]);
        });
        
        int len = costs.length;
        
        int sum = 0, a = 0, b = 0, mid = len/2;
        for(int[] cur : costs)
        {
            if(cur[0] < cur[1] && a < mid) {
                a++;
                sum += cur[0];
            }
            else if(cur[0] > cur[1] && b < mid) {
                b++;
                sum += cur[1];
            }
            else if(a < mid) {
                a++;
                sum += cur[0];
            }
            else {
                b++;
                sum += cur[1];
            }
        }
        
        return sum;
    }
    
}
 */
