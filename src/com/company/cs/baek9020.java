package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 골드바흐의 추측 
 */
public class baek9020 {

	static final int max_node = 10000;
	static int N;
	static int[] data = new int[10005];
	static int[] arr = new int[10005]; // 1 ~ 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= max_node; i++)
			data[i] = i;
		
		int index = 0;
		for(int i=2; i <= max_node; i++)
		{
			if(data[i] == 0 ) continue; 
			arr[++index] = i;
			for(int j = i * i; j<= max_node; j += i)
			{
				if(data[j] == 0) continue;
				data[j] = 0;
			}
		}
		
		for(int i=1; i<= testCase; i++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			int value =0, target =0, idx = 1;
			int num1 = 0, num2 = 0;
			int maxValue = 50000;
			while(N > arr[idx] && arr[idx] != 0)
			{
				value = arr[idx];
				target = N - value;
				
				if(search(1, index, target))
				{
					int minus = abs(value, target);
					if(maxValue > minus)
					{
						maxValue = minus;
						num1 = value > target ? target : value;
						num2 = value > target ? value : target;
					}
				}
				
				idx++;
			}
			bw.write(num1+" "+num2+"\n");
		}
		bw.flush();
	}
	public static boolean search(int s, int e, int target)
	{
		int mid =0;
		while( s <= e)
		{
			mid = ( s + e ) / 2;
			if(arr[mid] == target) return true;
			else if(arr[mid] < target) {
				s = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}
		return false;
	}
	public static int min(int a, int b) { return a > b ? b : a; }
	public static int abs(int a, int b) { return a > b ? a - b : b - a; }
}



