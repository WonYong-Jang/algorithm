package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 최대 상금 
 */
public class swExpert1244 {

	static int N , K; // 숫자 길이  , 교환 횟수 
	static int[] data = new int[7]; // 1 ~ 7
	static int[] check = new int[1000005]; // 각 교환 횟수 당 가장 큰 값 저장 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			K = Integer.parseInt(st.nextToken());
			N = str.length();
			
			for(int i=1; i<= N; i++) data[i] = str.charAt(i-1) - '0';
			for(int i=1; i<= K; i++) check[i] = 0;
			check[1] = calculate(); // 처음 값 넣어 둠 
			
			for(int i=1; i<= N-1; i++)
			{
				for(int j = i+1; j<= N; j++)
				{
					swap(i, j);
					solve(1);
					swap(i, j);
				}
			}
			
			bw.write("#"+k+" "+check[K]+"\n");
		}
		bw.flush();
	}
	public static void solve(int cnt)
	{
		int sum = calculate();
		if(check[cnt] > sum) return; // 값이 작으면 더이상 보지 않기
		check[cnt] = sum; // 값 갱신 
		
		if(cnt == K) return;
		 
		for(int i=1; i<= N-1; i++)
		{
			for(int j = i+1; j<= N; j++)
			{
				swap(i, j);
				solve(cnt+1);
				swap(i, j);
			}
		}
		
	}
	public static int calculate()
	{
		int sum =0, digit = 1;
		for(int i = N; i >0; i--)
		{
			sum += (digit * data[i]);
			digit *= 10;
		}
		return sum;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void swap(int i, int j)
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}






