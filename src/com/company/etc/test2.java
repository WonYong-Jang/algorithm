package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test2 {
    
    static int M ,N;
    static int[][] data, dp;
    static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        boolean result = true;
        int[] data = new int[46]; // 1 ~ 45
        int prevNum = 0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(num);
            
            if(num < 1 || num > 45 || prevNum >= num) {
                result = false;
                break;  
            }
            data[num]++;
            if(data[num] > 1) {
                result = false;
                break;
            }
            prevNum = num;
        }   
        
        
        System.out.println(result);
    }
}









