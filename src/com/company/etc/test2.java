package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test2 {
    
    static final int MAX_VALUE = 500000;
    static int N, H, start, end;
    static int[] tree = new int[MAX_VALUE*4];
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        start = 1;
        while(H > start) start *= 2;
        end = start + H -1;
        
        for(int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(i % 2 == 0) {
                internalCnt(1, num);
            }
            else {
                internalCnt(H-num+1, H);
            }
        }
        solve();
    }
    public static void solve() {
        
        int result = MAX_VALUE;
        int resultCnt = 0;
        for(int i=start; i<= end; i++) {
            
            int index = i;
            int sum = 0;
            while(index > 0) {
                sum += tree[index];
                index /= 2;
            }
            
            if(sum < result) {
                result = sum;
                resultCnt = 1;
            }
            else if(sum == result) resultCnt++;
        }
        System.out.println(result+ " " + resultCnt);
    }
    public static void internalCnt(int dx, int dy) {
        int s = dx + start - 1;
        int e = dy + start - 1;
        
        while(s <= e) {
            
            if(s % 2 != 0) tree[s]++;
            if(e % 2 == 0) tree[e]++;
            
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
    }
}









