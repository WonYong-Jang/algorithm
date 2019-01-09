package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 0 ( 그리디 알고리즘 )
 */
public class baek11047 {

	static int N, K, result;
	static int[] coin = new int[11];
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
		result = 0; // 최소 갯수 
		// 큰 동전부터 먼저 계산 
		for(int i=N; i>=1; i--) // 그리디 알고리즘 
		{
			if(K < coin[i]) continue;
			if(K == 0) break;
			result += K/coin[i];
			K %= coin[i];
		}
		System.out.println(result);
	}
}






