package com.company.etc;

public class test5 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {



    public static long solution(String s) {
    // Write your code here
        long answer = 0;
        
        int len = s.length();
        int cur = 0; // 현재 위치 A
        
        for(int i=0; i< len; i++) { 
            int target = s.charAt(i) - 'A';
            
            int count = 0, leftCnt = 0, rightCnt =0;
            
            int next = cur;
            for(int j=0; j< 26; j++) { // left move 
                
                if(next == target) {
                    leftCnt = count;
                    break;
                }
                count++;
                next--;
                if(next < 0) next = 25; // cycle
            }
            
            next = cur;
            count = 0;
            for(int j =0; j< 26; j++) { // right move
                
                if(next == target) {
                    rightCnt = count;
                    break;
                }
                count++;
                next++;
                if(next > 25) next = 0; // cycle
            }
            
            cur = target;
            
            answer += (long)Math.min(leftCnt, rightCnt);
        }
        
        return answer;
    }

}
**/

