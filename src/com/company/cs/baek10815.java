package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자 카드 
 */
public class baek10815 {

	static int N, M;
	static int[] data = new int[500005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data,1, N+1);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int num =0;
		for(int i=1; i<= M; i++)
		{
			num = Integer.parseInt(st.nextToken());
			if(search(1, N, num)) bw.write("1 ");
			else bw.write("0 ");
		}
		bw.flush();
	}
	public static boolean search(int s, int e, int target)
	{
		int mid =0;
		while(s <= e)
		{
			mid = (s + e) / 2;
			if(data[mid] == target) return true;
			else if(data[mid] < target) s = mid + 1;
			else e = mid -1;
		}
		return false;
	}
}
