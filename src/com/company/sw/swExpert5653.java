package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 줄기세포 배양 
 */
public class swExpert5653 {

	static final int max = 400;
	static int N, M, K, sdx, sdy, ans;
	static int[][][] map = new int[2][max][max]; // 0 : 생명력 기록  // 비활성 
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0 , 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			sdx = sdy = 151;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()) + sdx;
			M = Integer.parseInt(st.nextToken()) + sdy;
			K = Integer.parseInt(st.nextToken());
			init(); // 초기화 
			for(int i=sdx; i< N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=sdy; j< M; j++)
				{
					int temp = Integer.parseInt(st.nextToken());
					map[0][i][j] = temp; // 생명력 기록 
					if(temp > 0) 
					{
						map[1][i][j] = 0; // 비활성 시작 시간 기록 
						que.add(new Node(i, j, 0 , temp, 0));  
					}
				}
			}
			solve();
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		int time = 0, len =0;
		
		while(time <= K)
		{
			len = que.size();
			
			for(int i=0; i< len; i++)
			{
				Node n = que.poll();
				
				if(n.con ==0) // 비활 성 상태 
				{
					if(n.life + n.start == time) que.add(new Node(n.dx, n.dy, n.start, n.life, 1)); // 활성 상태로 
					else que.add(n); // 시간이 아직 안된 경우 그대로 넣기 
				}
				else if(n.con == 1) // 활성 상태 
				{
					for(int k=0; k<4; k++)
					{
						int nx = n.dx + dxArr[k];
						int ny = n.dy + dyArr[k];
						if(map[1][nx][ny] == -1)
						{
							if(map[0][nx][ny] < n.life)
							{
								map[0][nx][ny] = n.life;
								que.add(new Node(nx, ny, time, n.life, 0));
							}
						}
					}
					
					if(n.start + (n.life*2) > time )
					{
						que.add(n); // 활성 시간이 아직 남은 경우 그대로 넣어 주기 
					}
				}
			}
			
			len = que.size();
			
			for(int i=0; i< len; i++)
			{
				Node n = que.poll();
				if(n.life == map[0][n.dx][n.dy])
				{
					que.add(n);
					map[1][n.dx][n.dy] = n.start;
				}
			}
			
			time++;
		}
		
		ans = que.size();
	}
	public static void init()
	{
		que.clear();
		for(int k = 0; k< 2; k++)
		{
			for(int i=0; i< max; i++)
			{
				for(int j=0; j< max; j++)
				{
					map[k][i][j] = -1;
				}
			}
		}
	}
	static class Node {
		int dx, dy, start, life, con; // start 비활성 시작 시간 표시 , life 생명력 , con 현재 상태 
		Node(int a, int b, int c, int d, int e)
		{
			dx = a; dy = b; start = c; life = d; con = e; 
		}
	}
}
