package com.company.programmers;

public class pro12936 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n]; // 정답 배열 
        
        if(n ==0 || k ==0) return new int[0];
        
        ArrayList<Integer> arr = new ArrayList<>();        
        for(int i=0; i< n; i++) { // 초기값 설정
            arr.add(i+1);
        }
        
        int index = 0;
        long slice = 0;
        while(n > 1) { // n == 1 이 될 때까지 (맨 뒷자리수만 남을 때 까지)
            slice = fac(n) / n;
            int deleteIdx = (int)((k - 1) / slice);
            answer[index++] = arr.remove(deleteIdx);
            
            k = k % slice;
            if(k ==0) k = slice;
            n--;
        }
        answer[index] = arr.get(0);
        
        return answer;
    }
    public long fac(long num) {
        if(num <= 1) return num;
        else return num * fac(num-1); 
    }
}




 */

