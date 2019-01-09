package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 동전 1
 */
public class baek2293 {

	static int N, K;
	static int[] coin = new int[101]; // 보유한 동전 종류 
	static int[] dp = new int[10001]; 
	// N(n, k) : 거스름돈 K 원을 n개의 동전으로 만들수 있는 조합의 수 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
			// 거스름돈 k를 k-coin[i] 했을때 0이 나온 경우는 딱 맞게 거슬러줄수 있는 경우의 수 
		}
		dp[0] = 1;
		int num = 0;
		// 가진 동전들의 조합의 수
		//ex) 1을 만들수 있는 가짓수를 구해놓고 2를 만들수 있는 수 구할때 1을 만든 가짓수를 더해가면서 구함 
		for(int i=1; i<= N; i++)  
		{
			for(int j=1; j<= K; j++) // 구할 거스름돈 가격 
			{
				if(j - coin[i] < 0) num = 0; // base case 
				else num = dp[j-coin[i]]; // 동전 coin[i] 으로 만들수 있는 경우 
				
				dp[j] += num; // 이전에 만들어 놓은 갯수와 축적 
			}
		}
		
		System.out.println(dp[K]);
	}
}



