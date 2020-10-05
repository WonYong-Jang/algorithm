package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class test2 {
    
    
    public static void main(String[] args) throws IOException {
        
       ArrayList<String> arr = new ArrayList<>();
       String str1 = "Aa";
       String str2 = "aa";
       System.out.println(str1.compareTo(str2));
       arr.add("aa");
       arr.add("Aa");
       Collections.sort(arr);
       for(int i=0; i < arr.size(); i++) {
           System.out.println(arr.get(i));
       }
       
    }
    
}
/**
N <= 500000
탑의 높이 100,000,000
1,000,000,007

1. 검사하려는 탑의 높이 보다 큰 높이 ( 가장 가까운 위치 ) 의 탑이 나올때까지 찾는다.  
2. 스택의 맨 앞의 데이터 ( stack.peek() ) 가 검사 하려는 탑의 높이 보다 작으면 pop() 
3. 검사 완료된 탑은 stack.add  

Stack<Node> stack;
ArrayList<Node> arr; 
class Node {
  int height, int index;
}

2
5
6 9 5 7 4
5
1 1 4 2 1




8
7
 */

/**
import java.util.*;

class Solution {
    public long solution(int N, int K) {
        long answer = 0;
        
        long end = 1, index = 0;
        while(N > index) {
            end *= 2;
            index++;
        }
        
        long start = 0; // 
        
        for(int i=0; i< K; i++) {
            start += (1 << i);        
        }
        
        while(true) {
            if(start % 3 == 0) break;
            start++;
        }
        
        
        while(start < end ) {
            
            int cnt = bitCount(start);
            if(cnt == K) answer++;
            
            start += 3;
        }
        
        return answer;
    }
    public int bitCount(long num) {
        int cnt = 0;
        
        for(int i=0; i< 50; i++) {
            if( (num & (1L << i)) > 0 ) {
                cnt++; 
            }
        }
        
        return cnt;
    }
}
 */







