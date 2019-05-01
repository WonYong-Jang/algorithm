package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 팀 나누기 
 */
public class baek13866 {

	static int result;
	static int[] visit = new int[5];
	static int[] data = new int[5];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		data[1] = Integer.parseInt(st.nextToken());
		data[2] = Integer.parseInt(st.nextToken());
		data[3] = Integer.parseInt(st.nextToken());
		data[4] = Integer.parseInt(st.nextToken());
		result = 500000;
		int a = 0, b = 0;
		for(int i = 1; i <= 3; i++)
		{
			for(int j= i+1; j <= 4; j++)
			{
				visit[i] = 1;
				visit[j] = 1;
				a = data[i] + data[j];
				b = 0;
				for(int k=1; k<=4; k++)
				{
					if(visit[k] == 1) continue;
					b += data[k];
				}
				result = min(result, obs(a,b));
				visit[i] = 0;
				visit[j] = 0;
			}
		}
		System.out.println(result);
	}
	public static int obs(int a, int b)
	{
		return a > b ? a-b : b-a;
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}
