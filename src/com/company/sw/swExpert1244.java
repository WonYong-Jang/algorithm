package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 상금 ( 백트래킹 )
 */
public class swExpert1244 {

	static int N, len, result; // 교환 횟수 , 숫자 갯수  
	static int[] number = new int[6]; // 6자리 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			
			result = -1;
			len = str.length();
			
			for(int i=0; i< len; i++)
			{
				number[i] = str.charAt(i)- '0';
			}
			
			for(int i=0; i< len-1; i++)
			{
				for(int j=i+1; j<len; j++)
				{
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
					solve(1);
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
			
			System.out.println("#"+k+" "+result);
		}
	}
	public static void solve(int cnt)
	{
		if(cnt == N) { // 교환 횟수 
			int temp = 0, multi = 1;
			for(int i= len-1; i >=0 ; i--) // 계산 
			{
				temp += (number[i] * multi);
				multi *= 10;
			}
			result = Math.max(result, temp);
			return;
		}
		
		for(int i=0; i< len-1; i++)
		{
			for(int j=i+1; j<len; j++)
			{
				int temp = number[i];
				number[i] = number[j];
				number[j] = temp;
				solve(cnt+1);
				temp = number[i];
				number[i] = number[j];
				number[j] = temp;
			}
		}
	}
	
}
