package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부등호 
 */
public class baek2529 {

	static int N, chk;
	static String minNum, maxNum;
	static char[] op = new char[12]; // 1 ~ 10
	static int[] ans = new int[10]; // 0 ~ 9
	static boolean[] visit = new boolean[10]; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		chk = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			op[i] = st.nextToken().charAt(0);
		}
		minNum ="";
		maxNum ="";
		for(int i=0; i< 10; i++)
		{
			ans[0] = i;
			visit[i] = true;
			dfs(0, 1);
			visit[i] = false;
		}
		System.out.println(maxNum+"\n"+minNum+"\n");
	}
	public static void dfs(int index, int opCnt)
	{
		if(index == N)
		{
			String tmp ="";
			for(int i=0; i<= N; i++) {
				tmp += ans[i];
			}
			if(chk ==0) minNum = tmp;
			chk++;
			maxNum = tmp;
			return;
		}
		
		for(int i= 0; i< 10; i++)
		{
			if(isPromising(index ,opCnt, i))
			{
				ans[index+1] = i;
				visit[i] = true;
				dfs(index+1, opCnt+1);
				visit[i] = false;
			}
		}
	}
	public static boolean isPromising(int index, int opCnt, int num)
	{
		if(visit[num]) return false; // 중복된 숫자 확인 
		boolean flag = false;
		switch(op[opCnt])
		{
		case '<':
			if(ans[index] < num) {
				flag = true;
			}
			break;
		case '>': 
			if(ans[index] > num) {
				flag = true;
			}
			break;
		}
		
		return flag;
	}
}






