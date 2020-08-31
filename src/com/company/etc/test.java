package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test {
    
    static final int MAX_VALUE = 200005;
    static int N, H; 
    static int[] data1 = new int[MAX_VALUE]; // 석순 
    static int[] data2 = new int[MAX_VALUE]; // 종유석  
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        int len1=0, len2 = 0;
        for(int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(i % 2 == 0) {
                data1[len1++] = num; 
            }
            else {
                data2[len2++] = H - num;
            }
        }
        
        
        Arrays.sort(data1, 0, len1);
        Arrays.sort(data2, 0, len2);
        
        int result = MAX_VALUE;
        int resultCnt = 0;
        
        for(int i=0; i< H; i++) {
            
            int curHeight = i+1;
            int sum = 0;
            
            int index1 = lower_bound(0, len1, data1, curHeight);
            int index2 = lower_bound(0, len2, data2, curHeight);
            
            sum += (len1 - index1) + index2;
            
            if(sum < result) {
                result = sum;
                resultCnt = 1;
            }
            else if(sum == result) {
                resultCnt++;
            }
        }
        System.out.println(result+ " " + resultCnt);
    }
    public static int lower_bound(int s, int e, int[] dp, int target) {
        
        while( s < e) {
            int mid = (s + e) / 2;
            if(dp[mid] < target) {
                s = mid + 1;
            }
            else e = mid;
        }
        return e;
    }
}





