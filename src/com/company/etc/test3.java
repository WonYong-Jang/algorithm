package com.company.etc;

public class test3 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/*
class Solution {
    public int solution(String S) {
      int answer = 0;
      
      int len = S.length();
      int[] data = new int[27]; 
      for(int i=0; i< len; i++) {
          int num = S.charAt(i) - 'a';
          data[num]++;
      }
      for(int i=0; i< 27; i++) {
          if(data[i] > 0 && data[i] % 2 != 0) answer++;
      }
        
      return answer;
    }
  }
*/