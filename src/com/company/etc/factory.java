package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class factory {
    
    static int N, M, K, result, len;
    static int[] people = new int[6];
    static int[] order = new int[6];
    static int[] visit = new int[6];
    static int[][] arr = new int[5005][30];
    static int[][] dp = new int[5005][6];
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
            result = 0; len = 0;
            for(int i=1; i<= N; i++)
            {
                for(int j=1; j<= 26; j++)
                {
                    arr[i][j] = 0;
                }
            }
            String str = br.readLine();
            
            for(int i=1; i<= K; i++) {
                people[i] = str.charAt(i-1) - 'A' + 1;
                visit[i] = 0;
            }
            
            for(int i=1; i<= M; i++)
            {
                str = br.readLine();
                for(int j=1; j<= N; j++)
                {
                    arr[j][str.charAt(j-1) - 'A' + 1]++;
                }
            }
            
            for(int i=1; i<= K; i++)
            {
                visit[i] = 1;
                dfs(1, i);
                visit[i] = 0;
            }
            
            bw.write("#"+k+" "+result+"\n");
        }
        bw.flush();
    }
    public static void dfs(int size, int cur)
    {
        order[size] = people[cur];
        if(size == K) 
        {
            dp = new int[N+1][6];
            
            for(int i=1; i<= N; i++)
            {
                for(int j=1; j<= K; j++)
                {
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + arr[i][order[j]];
                    result = max(result,dp[i][j]);
                }
            }
            
            return;
        }
        
        for(int i=1; i<= K; i++)
        {
            if(visit[i] == 1) continue;
            visit[i] = 1;
            dfs(size+1, i);
            visit[i] = 0;
        }
        
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
