package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 조세퍼스 문제  ( 1158 ) 
 * 링크드 리스트 ( 집접 구현 해서 풀어보기 ) 
 */
public class baek1158 {

	static int N, M, index=0;
	static LinkedList<Integer> list = new LinkedList<>();
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		sb.append("<");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++) // input
		{
			list.add(i);
		}
		solve();
		System.out.println(sb);
	}
	public static void solve()
	{
		while(list.size() > 0)
		{
			for(int i=1; i<= M-1 ;i++)
			{
				index++;
				if(index > list.size()-1 ) index = 0;
			}
			sb.append(list.get(index)+", ");
			
			list.remove(index);
			
			if(index > list.size()-1) index =0;
		}
		sb.replace(sb.length()-2, sb.length(), ">");
		
	}
}







