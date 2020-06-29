package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test3 {
    
    static int N, zero, one; // zero : 0 갯수, one : 1의 갯수 
    static int[][] data;     // 입력값  
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        zero = 0; one = 0;
        data = new int[N+1][N+1];
        for(int i=1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<= N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        search(1, 1, N, N, N);  
        bw.write(zero+"\n");
        bw.write(one+"\n");
        bw.flush();
    }
    public static void search(int dx1, int dy1, int dx2, int dy2, int k) {
        
        if(check(dx1, dy1, dx2, dy2, k)) return; // 한가지 색으로 모두 색칠되어 있는지 확인 
        if(k == 1) return; // 높이가 1 이면 더이상 확인 X 
        int mid = k/2;     // 4 등분하기 위해 절반으로 자른 높이 
        
        search(dx1, dy1+mid, dx2-mid, dy2, mid); // 1사분면 
        search(dx1, dy1, dx2-mid, dy2-mid, mid); // 2사분면 
        search(dx1+mid, dy1, dx2, dy2-mid, mid); // 3사분면 
        search(dx1+mid, dy1+mid, dx2, dy2, mid); // 4사분면 
    }
    public static boolean check(int dx1, int dy1, int dx2, int dy2, int k) {
        int zeroCnt = 0, oneCnt =0;
        
        for(int i = dx1 ; i <= dx2; i++) {
            for(int j= dy1 ; j<= dy2; j++) {
                if(data[i][j] == 1) oneCnt++;
                else zeroCnt++;
            }
        }
        if(oneCnt == k*k ) {
            one++;
            return true;
        }
        else if(zeroCnt == k*k) {
            zero++;
            return true;
        }
        else return false;
    }
}
