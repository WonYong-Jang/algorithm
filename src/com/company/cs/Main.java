package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	static int N, K;
	static int[] coin = new int[105];
	static int[] coinCnt = new int[10005];
	static int[] lastCoin = new int[10005];
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
		}
		for(int i=1; i<= K; i++)
		{
			coinCnt[i] = INF;
			for(int j=1; j<= N; j++)
			{
				if(i - coin[j] >= 0)
				{
					if(coinCnt[i] > coinCnt[i-coin[j]] + 1)
					{
						coinCnt[i] = coinCnt[i-coin[j]] + 1;
						lastCoin[i] = coin[j];
					}
				}
			}
		}
		if(coinCnt[K] == INF) System.out.println(-1);
		else System.out.println(coinCnt[K]);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}
