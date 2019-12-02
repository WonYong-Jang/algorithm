package com.company.programmers;

import java.util.HashSet;

public class pro12981 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
    
}
/**
import java.util.*;
    
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] cntArr = new int[n+1];
        int cur = 0, turnCnt = 0;
        int len = words.length;
        HashSet<String> set = new HashSet<>();
        
        String first = "", second = "";
        
        for(int i=1; i<= len; i++)
        {
            cur = (cur % n) + 1;
            cntArr[cur]++;
            
            if(i != 1) {
                first = words[i-2].substring(words[i-2].length()-1,words[i-2].length());
                second = words[i-1].substring(0,1);
            }                
            
            if(set.contains(words[i-1]) || !first.equals(second))
            {
                turnCnt = cntArr[cur];
                break;
            }
            set.add(words[i-1]);
        }   
        
        answer[0] = cur;
        if(turnCnt == 0) answer[0] = 0;
        answer[1] = turnCnt;
        return answer;
    }
}
 */
