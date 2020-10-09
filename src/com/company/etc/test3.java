package com.company.etc;

public class test3 {
    
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

    

    public static String solution(long n) {
    // Write your code here
        
        String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alpa = data.split("");
        
        // A ~ Z , AA ~ AZ, ... ZA ~ ZZ 
        String[] cell = new String[702];  // column arr
        
        int idx = 0;
        for(int i=0; i< 27; i++) {
            String first = "";
            if(i > 0) {
                first = alpa[i-1];
            }
            for(int j=0; j< 26; j++) {
                if(i == 0) cell[idx++] = alpa[j];
                else cell[idx++] = first + alpa[j];
            }
        }
        
        long row = 0, col = 0;
        String answer = "";
        
        if(n % 702 == 0) { // 맨 오른쪽 열 
            row = n/702;
            answer = Long.toString(row) + "ZZ";
        }
        else {
            row = n/702 + 1;
            col = (n % 702) - 1;
            
            answer = Long.toString(row) + cell[(int)(col)];
        }
        
        return answer;
    }

}


**/