package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 퇴사  
 */
public class baek14501 {
	
	public static int N; // 전체 일수   
	public static int[][] map = new int[16][3];
	public static final int DATE=1, MONEY = 2;
	public static int maxValue = 0; // 최대값 초기화    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			map[i][DATE] = Integer.parseInt(st.nextToken()); // DATE
			map[i][MONEY] = Integer.parseInt(st.nextToken()); // MONEY
		}
		for(int i=1; i<= N; i++)
		{
			if(i+ map[i][DATE] -1 > N ) continue; // 일정이 넘어가게 되면 continue
			dfs(i, map[i][MONEY]);
		}
		
		System.out.println(maxValue);
	}
	public static void dfs(int date, int sum)
	{	
		System.out.println(date+" "+sum);
		
		maxValue = Integer.max(maxValue, sum);	
		
		int nextDate = date + map[date][DATE]; // 다음 일정으로  
		
		for(int i = nextDate ; i<= N; i++)
		{
			if(i+ map[i][DATE] -1 > N ) continue; // 일정이 넘어가게 되면 continue
			dfs(i, map[i][MONEY]+sum);
		}
		
	}

}
