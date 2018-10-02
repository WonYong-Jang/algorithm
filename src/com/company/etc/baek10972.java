package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek10972 {

	static boolean flag;
	static int N, target, cnt, tCnt;
	static int[] visit = new int[10005];
	static int[] output = new int[10005];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		cnt = 1;
		tCnt = -1;
		flag = false;
		for (int i = 1; i <= N; i++) {
			output[i] = Integer.parseInt(st.nextToken());
		}
		target = cal();

		for (int i = 1; i <= N; i++) {
			visit[i] = 1;
			solve(i, 1);
			visit[i] = 0;
			if (flag) break;
		}
	}
	public static void solve(int index, int depth)
	{
		output[depth] = index;
		if(depth == N)
		{
			int temp = cal();
			
			if(temp == target)
			{
				tCnt = cnt+1; // 다음 확인 
				if(tCnt > N) // 마지막 일경우 
				{
					System.out.println(-1);
					flag = true;
				}
			}
			if(tCnt == cnt)
			{
				for(int i=1; i<= N; i++)
				{
					System.out.print(output[i]+ " ");
				}
				System.out.println();
				flag = true;
			}
			cnt++; // 몇번째 인지 
			return;
		}
		else
		{
			for(int i=1; i<= N; i++)
			{
				if(visit[i] == 1) continue;
				visit[i] = 1;
				solve(i, depth + 1);
				visit[i] = 0;
				if (flag) break;
			}
		}
	}
	public static int cal() {
		int multi = 1;
		int sum = 0;
		for (int i = N; i >= 1; i--) {
			sum += (output[i] * multi);
			multi *= 10;
		}

		return sum;
	}
}
