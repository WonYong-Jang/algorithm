package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개똥벌레 ( 인덱스 트리로 구현 ) 
 */
public class baek3020 {

	static int N, H;
	static final int MAX = 500001;
	
	static int[] tree = new int[MAX * 4];
	static int index;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		index =1;
		while(H > index) index *=2; // 인덱스 트리 시작점 찾기 
		
		int temp =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			temp = Integer.parseInt(st.nextToken());
			
			if(i % 2 == 0) { // 종유석 
				internalCnt(H - temp + 1 ,H);
			}
			else { // 석순 
				internalCnt(1, temp);
			}
		}
		solve();
		
	}
	public static void internalCnt(int a, int b)
	{
		int a_index = a + index -1;
		int b_index = b + index -1;
		
		while(b_index >= a_index)
		{
			if(a_index % 2 != 0) tree[a_index]++; // cnt;
			a_index = (a_index+1) / 2;
			
			if(b_index % 2 == 0) tree[b_index]++;
			b_index = (b_index-1) / 2;
		}
	}
	public static void solve()
	{
		int curIdx =0, minCnt =0;
		int sum =0, result = Integer.MAX_VALUE;
		
		for(int i=index; i<index + H; i++)
		{
			sum =0;
			curIdx = i;
			while(curIdx > 0)
			{
				sum += tree[curIdx];
				curIdx /= 2; // 부모 노드로 이동 
			}
			if(result > sum) {
				minCnt =1;
				result = sum;
			}
			else if(result == sum) minCnt++;
		}
		System.out.println(result+" "+minCnt);
	}
	
}





