package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 벌꿀 채취 
 */
public class swExpert2115_2 {

	static int N, M, C, ans;
	static int[][] map = new int[12][12];
	static int[][] visit = new int[12][12];
	static ArrayList<Integer> arr1 = new ArrayList<>();
	static ArrayList<Integer> arr2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0; arr1.clear(); arr2.clear();
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i< N*N; i++)
			{
				int nx = (i/N)+1;
				int ny = (i%N)+1;
				if(visit[nx][ny] == 1) continue;
				
				visit[nx][ny] =1;
				arr1.clear();
				arr1.add(map[nx][ny]);
				solve(i, 1, 1, nx);
				visit[nx][ny] =0;
			}
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void check()
	{
		int value =0;
		for(int i=1; i< (1<<M); i++)
		{
			int sum1 =0, multi1=0;
			for(int j=0; j< M; j++)
			{
				if( (i & (1<<j) ) > 0 )
				{
					value = arr1.get(j);
					sum1 += value;
					multi1 += (value*value);
				}
			}
			if(sum1 > C) continue;
			
			for(int k=1; k< (1<<M); k++)
			{
				int sum2= 0, multi2 =0;
				for(int l=0; l< M; l++)
				{
					if((k & ( 1 << l)) > 0)
					{
						value = arr2.get(l);
						sum2 += value;
						multi2 += (value * value);
					}
				}
				if(sum2 > C) continue;
				ans = max(ans, multi1+multi2);
			}
		}
	}
	public static void solve(int index, int flag, int cnt ,int row)
	{
		int nx = 0, ny =0;
		if(flag == 1)
		{
			if(cnt == M) 
			{
				for(int i= index+1; i< N*N; i++)
				{
					nx = (i/N)+1;
					ny = (i%N)+1;
					if(visit[nx][ny] == 1) continue;
					
					visit[nx][ny] = 1;
					arr2.clear();
					arr2.add(map[nx][ny]);
					solve(i,2,1,nx);
					visit[nx][ny] = 0;
				}
			}
			else if(cnt < M)
			{
				int nIndex = index+1;
				nx = (nIndex/N)+1;
				ny = (nIndex%N)+1;
				if(visit[nx][ny] == 1 || row != nx) return;
				
				visit[nx][ny] = 1;
				arr1.add(map[nx][ny]);
				solve(nIndex, flag , cnt + 1,nx);
				visit[nx][ny] = 0;
			}
		}
		else if(flag == 2)
		{
			if(cnt == M)
			{
				check();
				return;
			}
			else if(cnt < M)
			{
				int nIndex = index+1;
				nx = (nIndex/N)+1;
				ny = (nIndex%N)+1;
				if(visit[nx][ny] == 1 || row != nx) return;
				
				visit[nx][ny] = 1;
				arr2.add(map[nx][ny]);
				solve(nIndex, flag , cnt + 1, nx);
				visit[nx][ny] = 0;
			}
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}



