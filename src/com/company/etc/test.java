package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test {
    
    
    public static void main(String[] args) throws IOException {
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

    

    public static int solution(List<Integer> arr) {
    // Write your code here
        int answer = -1;
        
        int len = arr.size();
        if(len <= 1) return answer;
        
        int minNum = arr.get(0);
        
        for(int i=1; i< len; i++) {
            
            if(minNum < arr.get(i)) { // 조건에 만족 할 때 
                answer = Math.max(answer, arr.get(i) - minNum); //최대 차이 구하기
            }
            minNum = Math.min(minNum, arr.get(i)); // 가장 작은 값 저장 
        }
        
        
        return answer;
    }

}

 
 */
