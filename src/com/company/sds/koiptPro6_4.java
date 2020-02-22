package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * koipt 풍선 
 */
public class koiptPro6_4 {
    
    static int N, ans;
    static int[] dp = new int[1000005];
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ans = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            if(dp[num+1] == 0) {
                ans++;
            }
            else {
                dp[num+1]--;
            }
            dp[num]++;
        }
        bw.write(ans+"\n");
        bw.flush();
    }
    
}
