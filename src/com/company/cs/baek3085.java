package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사탕 게임 
 */
public class baek3085 {

	static int N, ans;
	static char[][] map = new char[55][55];
	static int[] dxArr = {0, 1}, dyArr = {1 ,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ans = 1;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= N; j++)
			{
				map[i][j] = str.charAt(j-1);
			}
		}
		check(); // 초기상태 구하기 
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				for(int k=0; k< 2; k++)
				{
					int nx = i + dxArr[k];
					int ny = j + dyArr[k];
					if(!isRange(nx,ny)) continue;
					swap(i, j, nx, ny);
					check();
					swap(i, j, nx, ny);
				}
			}
		}
		
		bw.write(ans+"\n");
		bw.flush();
	}
	public static void check()
	{
		int count = 1;
		char target = ' ';
		
		for(int i=1; i<= N; i++)
		{
			target = map[i][1];
			count = 1;
			for(int j= 2; j<= N; j++)
			{
				if(target == map[i][j]) count++;
				else {
					ans = max(ans, count);
					count = 1;
					target = map[i][j];
				}
			}
			ans = max(ans, count);
			
			count = 1;
			target = map[1][i];
			for(int j = 2; j<= N; j++)
			{
				if(target == map[j][i]) count++;
				else {
					ans = max(ans, count);
					count = 1;
					target = map[j][i];
				}
			}
			ans = max(ans, count);
		}
		
	}
	public static void swap(int sdx, int sdy, int edx, int edy)
	{
		char temp = map[sdx][sdy];
		map[sdx][sdy] = map[edx][edy];
		map[edx][edy] = temp;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= N;
	}
}
