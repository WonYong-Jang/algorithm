package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 프린터 큐 
 *
 */
public class baek1966 {

	static int[] map = new int[101];
	static int N, M;
	static ArrayList<Integer> arr = new ArrayList<>(); 
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=0; k< testCase ; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			init(); // 초기화 함수 
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
			{
				int temp = Integer.parseInt(st.nextToken());
				que.add(temp);
				arr.add(temp);
			}	
			Collections.sort(arr);
			int result = solve(M);
			
			System.out.println(result);
		}
	}
	public static int solve(int index)
	{
		int cnt =1, checkIdx = arr.size()-1; // sorting 후 맨 뒤 인덱스가 가장 큰 값!
		int targetIdx = index; // 몇번째 출력인지 찾을 값 
		while(!que.isEmpty())
		{
			int value = que.poll();
			
			if(arr.get(checkIdx) == value) 
			{
				if(targetIdx ==0) break; // 찾은 경우 !
				else // 못 찾은 경우 ( 출력 ) 
				{
					cnt++; // 몇번째 출력했는지 카운트
					
					while(checkIdx > 0)
					{
						checkIdx--;
						if(arr.get(checkIdx) < arr.get(checkIdx+1)) break;
					}
				}
			}
			else que.add(value); // 못찾은 경우 다시 큐 맨뒤로 넣어줌 
			
			if(targetIdx == 0) targetIdx = que.size()-1; // 찾을 target value 
			else targetIdx--;
		}
		
		return cnt;
	}
	public static void init()
	{
		arr.clear();
		que.clear();
	}
}






