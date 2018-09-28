package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 보물상자 비밀번호 
 */
public class swExpert5658 {

	static int N, K, cut;
	static char[] data = new char[30]; // 1 ~ 28
	static HashSet<Integer> set = new HashSet<>();
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr.clear(); set.clear();
			cut = N / 4; // 변 4개로 나눠 
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			for(int i=0; i< str.length(); i++)
			{
				data[i] = str.charAt(i); // 입력 
			}
			
			for(int i=0; i< cut ;i++)
			{
				solve(i);
			}
			
			arr.addAll(set); // 정렬하기 위한 arr
			
			Collections.sort(arr,new mySort());
			
			int answer = arr.get(K-1);
			bw.write("#"+k+" "+answer+"\n");
		}
		bw.flush();
	}
	public static void solve(int cnt)
	{
		if(cnt > 0) shift(); // 쉬프트,  처음은 쉬프트 없이 진행 
		
		int index  = 0;
		for(int i=0; i< 4; i++) // 변 4개 
		{
			String temp = "";
			for(int j=0; j< cut; j++)
			{
				temp += data[index];
				index++;
			}
			int sum = transform(temp);
			set.add(sum);
		}
		
	}
	public static void shift() // 오른쪽 쉬프트 
	{
		int len = N-1; // 맨 마지막 인덱스 
		
		char[] tempArr = new char[30];
		char temp = data[len];
		
		
		for(int i=0; i<= len; i++)
		{
			tempArr[i] = data[i];
		}
		for(int i=0; i< len; i++)
		{
			data[i+1] = tempArr[i];
		}
		data[0] = temp;
	}
	public static int transform(String str) // 16진수 -> 10진수 변환 
	{
		int len = str.length();
		
		int result =0, num =0, temp =0;
		for(int i = len-1; i>= 0; i--)
		{
			if(i == len - 1) num = 1;
			else num *= 16;
			
			char target = str.charAt(i);
			if(target >= '0' && target <= '9') temp = target - '0';
			else temp = target - 'A' + 10;
			
			result += ( num * temp);
		}
		
		return result;
	}
	static class mySort implements Comparator<Integer>
	{
		@Override
		public int compare(Integer a, Integer b) {
			// TODO Auto-generated method stub
			if(a < b) return 1;
			else if(a > b) return -1;
			else return 0;
		}
		
	}
}



