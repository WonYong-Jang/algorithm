package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내려가기 
 */
public class baek2096 {

	static int N;
	static int[][] dp_max = new int[100005][4];
	static int[][] dp_min = new int[100005][4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int num = 0, maxValue = -1, minValue = Integer.MAX_VALUE;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=3; j++)
			{
				num = Integer.parseInt(st.nextToken());
				
				if(j==1) // 1, 2번과 인접 
				{
					dp_max[i][j] = max(num + dp_max[i-1][1], num + dp_max[i-1][2]);
					dp_min[i][j] = min(num + dp_min[i-1][1], num + dp_min[i-1][2]);
				}
				else if(j == 2) // 1, 2 ,3 과 인접
				{
					dp_max[i][j] = max(max(num + dp_max[i-1][1] , num + dp_max[i-1][2] ), num + dp_max[i-1][3]);
					dp_min[i][j] = min(min(num + dp_min[i-1][1] , num + dp_min[i-1][2] ), num + dp_min[i-1][3]);
				}
				else if(j ==3) // 2, 3 과 인접 
				{
					dp_max[i][j] = max(num + dp_max[i-1][2], num + dp_max[i-1][3]);
					dp_min[i][j] = min(num + dp_min[i-1][2], num + dp_min[i-1][3]);
				}
				if(i== N)
				{
					maxValue = max(maxValue, dp_max[i][j]);
					minValue = min(minValue, dp_min[i][j]);
				}
			}
		}
		
		System.out.println(maxValue+" "+minValue);
	}
	public static int max(int a, int b) { return a > b ? a: b; }
	public static int min(int a, int b) { return a > b ? b : a; }
}
