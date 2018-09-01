package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 입국 심사 ( 이분 탐색 ) 
 * 범위는 1 ~ 가장 오래 걸리는 심사대 * 사람수 ! ==> 첫번째 예시 1 ~ 60
 * 위의 범위를 이용해서 중간값 mid = 30 안에 6명을 심사 할수 있는지, 심사 할수 있다면 가장 적게 걸리는 시간을 찾으면 정답! 
 * 
 */
public class swExpert3074 {

	static long ans;
	static int N, M;
	static long[] data = new long[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase ;k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				data[i] = Long.parseLong(st.nextToken());
			}
			qSort(1, N); // 퀵 쏘트 
			
			binarySearch(1, data[N]*M);
			
			bw.write("#"+ k+ " "+ans+"\n");
		}
		bw.flush();
	}
	public static void binarySearch(long left, long right) // 이분 탐색 
	{
		if(left > right) return;
		
		long mid = (left + right) / 2;
		
		long sum = 0, temp = 0;
		for(int i=1; i<= N; i++) // 사람 인원수만큼 확인 
		{
			temp = mid/data[i]; // mid 라는 몇명 심사 할수 있는지 나누면 나오겠지 몫 만 
			if(temp == 0) break;
			sum += temp;
		}
		if(sum > M) {
			ans = mid; // 해당 인원수를 mid 시간만큼 심사 가능하기 때문에 답이 될 가능성이 있기에 
			binarySearch(left, mid-1);
		}
		else if( sum < M) binarySearch(mid+1, right);
		else if( sum == M) {
			ans = mid;
			binarySearch(left, mid-1); // 더 적은 시간으로 처리할수 있는게 있는지 끝까지 확인 ! 
		}
		
	}
	public static void qSort(int left, int right) // 퀵 소트 
	{
		if(left >= right) return;
		
		int pivot = partition(left, right);
		qSort(left, pivot-1);
		qSort(pivot+1, right);
	}
	public static int partition(int left, int right)
	{
		int mid = (left + right) / 2;
		swap(left, mid);
		
		int j = left;
		long pivot = data[left];
		
		for(int i= left+1; i<= right; i++)
		{
			if(pivot > data[i])
			{
				j++;
				swap(i,j);
			}
		}
		swap(j,left);
		
		return j;
	}
	public static void swap(int i, int j)
	{
		long temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
