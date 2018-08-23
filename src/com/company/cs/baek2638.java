package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치즈( 접촉한 면 2 이상일 때 녹는 조건 ) 
 */
public class baek2638 {

	static int N, M, min;
	static int[][] data = new int[105][105];
	static int[][] visit = new int[105][105];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		while(true)
		{
			min++;
			checkMelt(); // 치즈 녹을 부분 체크
			
			if(check()==0) break;
		}
		
		System.out.println(min);
	}
	public static void checkMelt()
	{
		que.clear();
		que.add(new Node(1,1));
		visit[1][1] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1 ) continue;
				
				if(data[nx][ny] > 0) data[nx][ny]++; // 추후 3이상 값이 있다면 2면 이상 이 공기에 접촉했다는 것! 
				else if(data[nx][ny] ==0 )
				{
					que.add(new Node(nx, ny));
					visit[nx][ny] = 1;
				}
			}
		}
	}
	public static int check()
	{
		int result =0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 0;
				if(data[i][j] >= 3) data[i][j] = 0; // 2면 이상 공기 접촉 
				else if(data[i][j] == 1) result++; // 녹일 치즈 얼마나 있는지 체크  
				else if(data[i][j] == 2) {
					data[i][j] = 1; // 한면만 접촉한 경우
					result++;
				}
			}
		}
		return result;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx<= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}
