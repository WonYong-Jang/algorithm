package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 2 (DP) 
 */
public class baek2294 {

	static int N, K;
	static int[] coin = new int[105]; // 거슬러줄수 있는 동전 갯수 
	static int[] coinUsed = new int[10005]; // 최소 동전 갯수 기록 
	static int[] lastCoin = new int[10005]; // 마지막 사용 동전 기록 
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
		
		for(int i=1; i<= K; i++) coinUsed[i] = -1;
		
		boolean flag = false;
		int minCnt =0, lastCent =0; // 동전의 최소 갯수와 마지막 쓰인 동전 확인 
		for(int curCent=1; curCent <= K; curCent++)
		{
			minCnt = 10005; // 가장 많은 갯수로 초기화  
			flag = false;
			for(int i=1; i<= N; i++) // 가진 동전 갯수만큼 확인 
			{
				if(curCent < coin[i]) continue; // 현재 가격보다 보유하고 있는 코인가격이 크다면 볼필요 없음
				if(coinUsed[curCent - coin[i]] + 1 < minCnt && coinUsed[curCent - coin[i]] != -1)
				{
					minCnt = coinUsed[curCent - coin[i]] + 1; // 최소 갯수 저장 
					lastCent = coin[i]; // 마지막 동전 저장 
					flag = true; // 동전 교환이 가능 체크 
				}
			}
			if(flag)
			{
				coinUsed[curCent] = minCnt; // 최종 값 저장 
				lastCoin[curCent] = lastCent;
			}
		}
		
		if(coinUsed[K] == -1) System.out.println(-1);
		else System.out.println(coinUsed[K]);
	}
}






