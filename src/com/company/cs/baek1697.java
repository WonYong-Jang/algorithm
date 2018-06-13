package com.company.cs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek1697 {
	
	public static final int INF = 200001;
	public static int start, end;  
	public static int[] dxArr = new int[] {-1,1,2};
	public static int[] ans = new int[INF];
	public static void bfs(int v)
	{
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		while(!que.isEmpty()) {
			int curValue = que.peek();
			if(curValue == end) break;
			
			que.poll();
			for(int i=0; i<3; i++) {
				int nextValue = dxArr[i] != 2 ? curValue+dxArr[i] : curValue*dxArr[i]; // 2일 경우 곱하기 2 
				if(nextValue >= 0 && nextValue < INF && nextValue != start && ans[nextValue] ==0)
				{
					ans[nextValue] = ans[curValue] +1; // 시간 증가 
					que.add(nextValue);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		start = scanner.nextInt();
		end = scanner.nextInt();
		
		bfs(start);
		
		System.out.println(ans[end]);
	}

}
