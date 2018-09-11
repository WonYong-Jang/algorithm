package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최소값 ( 세그멘트 트리 / 인덱스 트리 ) 
 */
public class baek10868 {

	static final int max = 100005;
	static int N, M, s, e, ans;
	static int INF = Integer.MAX_VALUE;
	static int[] data = new int[4*max];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startIndex = 0, endIndex = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		s = e = 1; // 시작 인덱스와 끝 인덱스 
		while(N > s) s *=2; // 처음 인덱스 선택 
		e = s + N -1; // 끝점 구하기 
		
		for(int i= s; i <=e ; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		setTree(); // 트리 구성 
		//debug();
		for(int i=1; i<= M; i++) // start command
		{
			st = new StringTokenizer(br.readLine());
			startIndex = Integer.parseInt(st.nextToken());
			endIndex = Integer.parseInt(st.nextToken());
			solve(startIndex, endIndex);
		}
	}
	public static void solve(int start, int end)
	{
		int sIndex = start + s - 1; // 실제 인덱스로 변환 
		int eIndex = end + s - 1;
		ans = INF;
		while(sIndex <= eIndex)
		{
			if(sIndex % 2 !=0) ans = min(data[sIndex], ans);
			sIndex = (sIndex+1) / 2;
			
			if(eIndex % 2 == 0) ans = min(data[eIndex], ans);
			eIndex = (eIndex-1) / 2;
		}
		
		System.out.println(ans);
	}
	public static void setTree()
	{
		for(int i = e/2; i > 0; i--)
		{
			if(data[i*2] == 0 ) data[i*2] = INF;
			if(data[i*2 + 1] == 0 ) data[i*2 + 1] = INF;
			data[i] = min(data[i*2], data[i*2+1]);
		}
	}
	public static void debug()
	{
		for(int i=1; i<= e; i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}
