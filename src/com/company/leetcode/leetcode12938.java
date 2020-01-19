package com.company.leetcode;

import java.util.ArrayList;

public class leetcode12938 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<5; i++)
        {
            int num = arr.get(0);
            
        }
    }
    
}
/**
import java.util.*;

class Solution {
  public int[] solution(int n, int s) {
      int[] answer = new int[n];
      
      if(n > s) return new int[]{-1};
      
      int value = s / n;
      int sum = s % n;
      
      
      for(int i = 0; i < n; i++)
      {
          answer[i] = value;
      }
      
      for(int i = n-1; i>= 0; i--)
      {
          if(sum == 0) break;
          answer[i]++;
          sum--;
      }
      
      
      return answer;
  }
}
 */
