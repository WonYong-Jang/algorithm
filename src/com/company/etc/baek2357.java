package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최소값과 최대 값 ( 세그먼트 트리 / 인덱스 트리  ) 
 */
public class baek2357 {

	static final int max = 100005;
	static int N, M, s, e;
	static int[] maxTree = new int[4*max];
	static int[] minTree = new int[4*max];
	static int maxValue = Integer.MAX_VALUE;
	static int minValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		s = e = 1;
		while(N > s) s *= 2;
		e = s + N -1; 
		
		for(int i = s; i <= e; i++)
		{
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			maxTree[i] = temp;
			minTree[i] = temp;
		}
		setMaxTree();
		setMinTree();
		//debug();
		int start = 0, end = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			minCheck(start, end);
			maxCheck(start, end);
		}
		
	}
	public static void minCheck(int start, int end)
	{
		int sIndex = start + s - 1;
		int eIndex = end + s - 1;
		int ans = maxValue;
		while(sIndex <= eIndex)
		{
			if(sIndex % 2 != 0) ans = min(ans, minTree[sIndex]);
			sIndex = (sIndex +1) / 2;
			
			if(eIndex % 2 ==0) ans = min(ans, minTree[eIndex]);
			eIndex = (eIndex -1) / 2;
		}
		System.out.print(ans+" ");
	}
	public static void maxCheck(int start, int end)
	{
		int sIndex = start + s - 1;
		int eIndex = end + s - 1;
		int ans = minValue;
		while(sIndex <= eIndex)
		{
			if(sIndex % 2 != 0) ans = max(ans, maxTree[sIndex]);
			sIndex = (sIndex +1) / 2;
			
			if(eIndex % 2 ==0) ans = max(ans, maxTree[eIndex]);
			eIndex = (eIndex -1) / 2;
		}
		System.out.println(ans);
	}
	public static void setMaxTree()
	{
		// 가장 끝 값의 부모 노드부터 역순부터 트리 구성
		for(int i = e / 2 ; i > 0; i--)  
		{
			if(maxTree[i*2] == 0) maxTree[i*2] = minValue;
			if(maxTree[i*2+1] == 0) maxTree[i*2+1] = minValue;
			maxTree[i] = max(maxTree[i*2], maxTree[i*2 + 1]);
		}
	}
	public static void setMinTree()
	{
		for(int i = e /2 ; i > 0; i--)
		{
			if(minTree[i*2] == 0) minTree[i*2] = maxValue;
			if(minTree[i*2+1] == 0) minTree[i*2+1] = maxValue;
			minTree[i] = min(minTree[i*2], minTree[i*2 + 1]);
		}
	}
	public static void debug()
	{
		for(int i=1; i<= e; i++)
		{
			System.out.print(maxTree[i]+" ");
		}
		System.out.println();
		
		for(int i=1; i<= e; i++)
		{
			System.out.print(minTree[i]+" ");
		}
		System.out.println();
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}
