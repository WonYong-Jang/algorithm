package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 쉬어가는 페이지 
 */
public class sds_page {

	static int[] page = new int[10001]; // 전체 페이지
	static int[] breakPage; // 쉬어 가는 페이지  
	static int N, S, J, K, cnt; // 전체 페이지 수, 시작 페이지, 건너뛸 페이지, 쉬는 페이지, 결과값  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			J = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			breakPage = new int[10001]; // 쉬어가는 페이지
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< K; i++)
			{
				int idx = Integer.parseInt(st.nextToken());
				breakPage[idx]++; // 해당 인덱스에 체크 
			}
			cnt =0;
			dfs(S);
			System.out.println("#"+k+" "+cnt);
		}
	}
	public static void dfs(int curPage)
	{
		if(curPage > N || curPage < 1) return; // base case 
		
		if(breakPage[curPage] == 1) cnt++;
		
		dfs(curPage + J + 1);
		
	}
	
}
