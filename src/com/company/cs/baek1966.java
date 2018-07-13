package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 프린터 큐 
 */
public class baek1966 {

	static int N, M;
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
				que.add(Integer.parseInt(st.nextToken()));
			}	

			int result = solve(M);
			
			System.out.println(result);
		}
	}
	public static int solve(int index)
	{
		PriorityQueue<Integer> maxArr = new PriorityQueue<>(new Mysort());
		maxArr.addAll(que);
		int cnt = 1;
		int targetIdx = index; // 몇번째 출력인지 찾을 값 
		int maxValue = maxArr.poll(); // 가장 큰 값 셋팅 
		
		while(!que.isEmpty())
		{
			int value = que.poll();
			//System.out.println(value+" "+targetIdx+" "+maxValue);
			if(maxValue == value) 
			{
				if(targetIdx ==0) break; // 찾은 경우 !
				else // 못 찾은 경우 ( 출력 ) 
				{
					cnt++; // 몇번째 출력했는지 카운트
					
					maxValue = maxArr.poll();
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
		que.clear();
	}
	private static class Mysort implements Comparator<Integer>
	{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if(o1 < o2) return 1;
			else if(o1 > o2) return -1;
			else return 0;
		}
		
	}
}






