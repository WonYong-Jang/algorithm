package com.company.programmers;

import java.util.Arrays;

public class pro42576 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/*
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int cLen = completion.length;
        int pLen = participant.length;
        
        Arrays.sort(completion, 0, cLen);
        Arrays.sort(participant, 0, pLen);
        
        answer = participant[pLen-1];
        for(int i=0; i< cLen; i++)
        {
            if(completion[i].equals(participant[i])) continue;
            
            if(completion[i].equals(participant[i+1])) {
                answer = participant[i];
                break;
            }
            else if(participant[i].equals(completion[i+1])){
                answer = completion[i];
                break;
            }
            
        }
        
        return answer;
    }
    
}
*/