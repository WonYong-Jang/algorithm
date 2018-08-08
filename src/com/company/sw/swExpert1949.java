package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 등산로 조정 
 */
public class swExpert1949 {
	
	static int[][] map = new int[11][11];
	static int N, K, result=0, maxValue=0;
	static int[] dxArr ={0,1,0,-1}, dyArr ={1,0,-1,0};
	static ArrayList<Node> arr = new ArrayList<>();
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=1; k<= testCase; k++)
		{
			result =0; // 초기화  
			maxValue=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int temp=0;
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					maxValue = Math.max(maxValue, temp);
				}
			}
			addMaxValue();
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					for(int m = 1; m <= K; m++)
					{
						map[i][j] -= m; 
						solve();
						map[i][j] += m;
					}
				}
			}
			
			System.out.println("#"+k+" "+result);
		}
	}
	public static void solve()
	{
		for(int i=0; i<arr.size(); i++)
		{
			if(map[arr.get(i).dx][arr.get(i).dy] == maxValue) que.add(arr.get(i));
		}
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			int rCnt = node.cnt;
			
			for(int i=0; i<4; i++)
			{
				int rDx = node.dx + dxArr[i];
				int rDy = node.dy + dyArr[i];
				
				if((isRange(rDx,rDy)) && map[node.dx][node.dy] > map[rDx][rDy])
				{
					que.add(new Node(rDx,rDy,rCnt+1));
				}
				else if(map[node.dx][node.dy] <= map[rDx][rDy] )
				{
					result = Math.max(result, rCnt);
				}
			}
		}
	}
	public static void addMaxValue() // 높은 봉우리만 que 에 담기 // 큰 봉우리가 최대 5번 넘을 경우도 있나????
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(map[i][j] == maxValue) arr.add(new Node(i,j,1));
			}
		}
	}
	public static boolean isRange(int dx, int dy) {
		return dx >=1 && dy >=1 && dx<= N && dy <=N;
	}
	public static class Node {
		int dx, dy, cnt;
		Node(int x, int y, int z) {
			dx =x; dy=y; cnt =z;
		}
	}
}




