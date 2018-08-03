package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 공약수 
 */
public class baek2824 {

	static int N, M;
	static final long MOD = 1000000000L;
	static long[] N_arr = new long[1001];
	static long[] M_arr = new long[1001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			N_arr[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= M; i++)
		{
			M_arr[i] = Long.parseLong(st.nextToken());
		}
		long result =1, temp=0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(N_arr[i] > M_arr[j]) temp = gcd(N_arr[i] , M_arr[j]);
				else temp = gcd(M_arr[j], N_arr[i]);
				N_arr[i]/=temp; M_arr[j]/=temp;
				System.out.println(N_arr[i] +" "+ M_arr[j]+" " + temp);
				result *= (long)temp;
			}
		}
		if(result >= 1000000000) System.out.printf("%09d\n",result);
		else System.out.println(result);
	}
	public static long gcd(long a, long b)
	{
		if(b==0) return a;
		else return gcd(b, a%b);
	}
}













