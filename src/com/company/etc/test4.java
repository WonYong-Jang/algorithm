package com.company.etc;

public class test4 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/**
class Solution {
    public int solution(int[] paper ) {
      int answer = 0;
      
      int len = paper.length;
      Arrays.sort(paper);
      int sum =0;
      int cnt = len;
      
      for(int i=0; i< len; i++) sum += paper[i];
      
      for(int i=0; i< len; i++) {
          if(sum >= cnt*cnt)
          {
              answer = cnt;
              break;
          }
          else {
          sum -= paper[i];
          cnt--;
          }
      }
        
      return answer;
    }
  } 
 */
