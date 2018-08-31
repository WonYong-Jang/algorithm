package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연구소 
 */
public class baek14502 {

	static int N, M, ans, result;
	static int[][] map = new int[9][9]; // 원본 배열 
	static int[][] virus = new int[9][9]; // 바이러스 퍼트려 안전영역 갯수 확인할 배열 
	static int[][] visit = new int[9][9]; // 
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	static ArrayList<Node> arr = new ArrayList<>(); // 바이러스 저장할 배열 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 10000;
		int temp =0, cnt = 3; // 벽 3개 더 놓을 예정이므로 
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp != 0 ) cnt++; // 미리 갯수 세어놓고 최대값 구하기 
				if(temp == 2 ) arr.add(new Node(i,j)); // 바이러스 위치 저장 
			}
		}
		ans = N * M - cnt; // 1, 2 제외한 0갯수 미리 계산해 놓기 
		
		for(int i=0; i< N*M; i++)
		{
			visit[i/M + 1][i % M + 1] = 1; // 벽을 세움 
			solve(i, 1);
			visit[i/M + 1][i% M + 1] = 0;
		}
		System.out.println(ans - result);
	}
	public static void solve(int index, int cnt)
	{
		
		if(cnt == 3)
		{
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= M; j++)
				{
					virus[i][j] = visit[i][j];
				}
			}
			int count = startVirus();
			
			result = min(result, count);
			//System.out.println("//"+result);
			return;
		}
		
		for(int i=index+1; i< N*M; i++)
		{
			if(visit[i/M + 1][i% M + 1] == 1 ) continue;
			visit[i/M + 1][i% M + 1] = 1;
			solve(i, cnt + 1);
			visit[i/M + 1][i% M + 1] = 0;
		}
	}
	public static int startVirus()
	{
		que.addAll(arr);
		int cnt = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i< 4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx,ny) || map[nx][ny] != 0 || virus[nx][ny] == 1) continue;
				virus[nx][ny] = 1;
				que.add(new Node(nx,ny));
				cnt++;
			}
			
		}
		return cnt; // 바이러스 2 몇개 퍼졌는지 
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}
