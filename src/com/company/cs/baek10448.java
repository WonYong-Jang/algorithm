package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 유레카 이론  
 *
 */
public class baek10448 {
	
	static int K;
	static int flag = 0;
	static int[] map = new int[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		int target =0;
		setting(); // 삼각수의 합 미리 배열에 저장  
		for(int i=0; i< K; i++)
		{
			flag = 0;
			target = Integer.parseInt(br.readLine());
			for(int j=1; j<= target ; j++)
			{
				if(map[j] > 1000) break; // 제한 조건 확인  
				solve(target, 1, map[j]);
			}
			
			System.out.println(flag);
		}
	}
	public static void solve(int target, int cnt, int sum)
	{ 
		if(flag == 1) return; // 유레카 이므로  더이상 찾지 않음
		if(cnt == 3) // 3개 숫자 합 일때 
		{
			// 확인  
			if(target == sum) flag = 1;
			return;
		}
		for(int i= 1; i <=target; i++)
		{
			if(map[i] > 1000) break;
			solve(target, cnt+1, sum+map[i] );
		}
	}
	public static void setting()
	{
		for(int i=1; i<=45;i++) // 1, 3, 6, 10, 15...
		{
			map[i] = (i*(i+1)) /2;
		}
	}
}









