package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 물통 
 */
public class baek2251 {
	
	static int A, B, C;
	static int[] limit = new int[3]; // 제한 양 표시 
	static HashSet<Integer> set = new HashSet<>();
	static int[][][] visit = new int[205][205][205]; // 
	static Queue<Node> que = new LinkedList<>();
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		limit[0] = A; limit[1] = B; limit[2] = C; 
		solve();
		
		Collections.sort(arr);
		
		for(int result : arr)
		{
			System.out.print(result+" ");
		}
		//debug();
	}
	public static void solve()
	{
		que.add(new Node(0,0,limit[2])); // 세번째 물의 양에서 부터 시작 ! 
		visit[0][0][limit[2]] = 1;
		
		int[] temp = new int[3];
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.amount[0] == 0) arr.add(n.amount[2]); 
				//set.add(n.amount[2]); // a 의 양이 0이라면 c 담겨있는 양 
			
			for(int i=0; i<3; i++) // i
			{
				if(n.amount[i] == 0) continue; // 빼서 줄 물이 없으면 패스 
				for(int j=0; j<3; j++) // j     i -> j   // i 물 빼서 j 에 추가 
				{
					if( i == j ) continue;
					
					for(int k=0; k<3; k++) {
						temp[k] = n.amount[k];
					}
					
					if( n.amount[i] + n.amount[j] > limit[j] ) 
					{
						temp[i] = n.amount[i] - (limit[j] - n.amount[j]);
						temp[j] = limit[j];
					}
					else 
					{
						temp[j] = temp[j] + temp[i];
						temp[i] = 0;
						
					}
					
					if(visit[temp[0]][temp[1]][temp[2]] == 1) continue;
					visit[temp[0]][temp[1]][temp[2]] = 1;
					que.add(new Node(temp[0],temp[1],temp[2]));
				}
			}
		}
	}
	public static void debug()
	{
		for(int i=0; i< 10; i++)
		{
			for(int j=0; j< 10; j++)
			{
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
	}
	static class Node {
		int[] amount = new int[3];
		Node(int x, int y, int z) {
			amount[0] = x; amount[1] = y; amount[2] = z;
		}
	}
}





