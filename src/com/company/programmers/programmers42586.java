package com.company.programmers;

public class programmers42586 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        int len = progresses.length;
        int cnt = 0, maxNum = 0;
        for(int i=0; i< len; i++) {
            int num = 100 - progresses[i];
            int val = num / speeds[i];
            if(num % speeds[i] != 0 && num > speeds[i]) val++;
            if(i == 0 ) {
                maxNum = val;
                cnt++;
            }
            else {
                if(maxNum >= val) cnt++;
                else {
                    arr.add(cnt);
                    maxNum = val;
                    cnt = 1;
                }
            }
        }
        arr.add(cnt);
        answer = new int[arr.size()];
        for(int i=0; i< arr.size(); i++) answer[i] = arr.get(i);
        
        return answer;
    }
} 
 */
