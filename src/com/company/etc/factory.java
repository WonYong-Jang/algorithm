package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class factory {
    
    static final int eCnt = 5;
    static int N, M, K, result, len;
    static HashMap<Character, Integer>[] map = new HashMap[5005];
    static int[][][] dp = new int[6][6][5005];
    static char[] eng = new char[6];
    static int[] engCnt = new int[6];
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for(int k=1; k<= testCase; k++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            for(int i=1; i<= N; i++) map[i] = new HashMap<>();
            
            for(int i=1; i<= eCnt; i++) engCnt[i] = 0;
            
            for(int a = 1; a <= eCnt; a++) {
                for(int b = 1; b <= eCnt; b++) {
                    for(int c = 1; c <= N; c++) {
                        dp[a][b][c] = 0;
                    }
                }
            }
            result = 0; 
            int num = 0, len = 1;
            char temp = 0;
            
            String str = br.readLine().trim();
            eng[1] = str.charAt(0);
            engCnt[1] = 1; 
            for(int i = 2; i <= str.length(); i++)
            {
                temp = str.charAt(i-1);
                int j = 1, flag = 0;
                for(j = 1; j <= len; j++) {
                    if(eng[j] == temp) {
                        engCnt[j]++;
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    eng[++len] = temp;
                    engCnt[len] = 1;
                }
            }
            
            for(int i=1; i<= M; i++)
            {
                str = br.readLine().trim();
                for(int j=1; j<= N; j++)
                {
                    temp = str.charAt(j-1);
                    if(map[j].containsKey(temp))
                    {
                        num = map[j].get(temp);
                        map[j].put(temp, num+1);
                    }
                    else map[j].put(temp, 1);
                }
            }
           
           
           for(int i = 1; i <= N; i++)
           {
               
           }
            
            bw.write("#"+k+" "+result+"\n");
        }
        bw.flush();
    }

    public static int max(int a, int b) { return a > b ? a : b; }
    public static int min(int a, int b) { return a > b ? b : a; }
}

/*
4      // 테스트케이스 개수 
5 5 1  // 1번째 케이스 
A 
AAEFM 
BDEKN 
ADFJN 
ACFIM 
ABGHA 
5 5 1  // 2번째 케이스 
F 
AAEFM 
BDEKN 
ADFJN 
ACFIM 
ABGHA 
5 5 3  // 3번째 케이스 
GFA 
AAEFM 
BDEKN 
ADFJN 
ACFIM 
ABGHA 
5 5 4  // 4번째 케이스 
BAZA 
AACBA 
ABCHU 
ACFIA 
ABKPA 
AAZMA 
 */
