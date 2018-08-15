package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * View 
 */
public class swExpert1206 {

	static int[] data = new int[1001];
	static int N, ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int k=1; k<= 10; k++) // 테스트 케이스 10 
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ans = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= N; i++)
			{
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<= N; i++)
			{
				if(data[i] == 0) continue;
				if(isRange(i-1) && isRange(i+1) && isRange(i-2) && isRange(i+2)) // 거리 2칸씩 거리 확인  
				{
					int maxValue = 0;
					int temp1 = max(data[i - 2], data[i - 1]);
					int temp2 = max(data[i + 2], data[i + 1]);
					maxValue = max(temp1, temp2); // 가장 높이가 긴 빌딩과 비교 
					if(maxValue < data[i]) {
						ans += ( data[i] - maxValue );
					}
					
				}
			}
			bw.write("#" + k + " " + ans + "\n");
		}
		bw.flush();
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static boolean isRange(int dx)
	{
		return dx >=1 && dx <= N;
	}
}
