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
 * 줄기 세포 배양 !!
 */
public class swExpert5653_2 {

	static int N, M, K, ans;
	static int[][] map = new int[400][400];
	static int[][] visit = new int[400][400]; // 비활성 시작 배열
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
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
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			init();
			ans = 0;
			int dx = 160, dy = 160;
			for(int i=dx; i< dx + N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j= dy; j< dy+ M; j++)
				{
					int num = Integer.parseInt(st.nextToken()); 
					if(num > 0)
					{
						map[i][j] = num;
						visit[i][j] = 0; // 비활성 시작 0
						que.add(new Node(i, j, num, 0));
					}
				}
			}
			solve();
			//debug();
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		int min=0, len =0;
		while(true)
		{
			if(min == K) break;
			//if(min == 10) break;
			min++;
			len = que.size();
			for(int i=0; i<len; i++)
			{
				Node n = que.poll();
				if(n.state ==0) // 비활성 상태 
				{
					if(min == visit[n.dx][n.dy] + map[n.dx][n.dy]) 
					{
						que.add(new Node(n.dx, n.dy, n.num, 1));
					}
					else que.add(n); // 더 기달려야함 
				}
				else if(n.state == 1) // 비활성 상태 
				{
					if(min <= (visit[n.dx][n.dy] + (map[n.dx][n.dy]*2)))
					{
						for(int k=0; k<4; k++)
						{
							int nx = n.dx + dxArr[k];
							int ny = n.dy + dyArr[k];
							if(visit[nx][ny] == -1 || visit[nx][ny] == min)
							{
								if(map[nx][ny] < map[n.dx][n.dy]) {
									map[nx][ny] = map[n.dx][n.dy];
									visit[nx][ny] = min;
									que.add(new Node(nx, ny, map[nx][ny], 0));
								}
							}
						}
					}
					if(min < (visit[n.dx][n.dy] + (map[n.dx][n.dy]*2)))
					{
						que.add(n);
					}
				}
			}
			
			len = que.size();
			for(int i=0; i<len; i++)
			{
				Node n = que.poll();
				if(map[n.dx][n.dy] != n.num) continue;
				que.add(n);
			}
		}
		ans = que.size();
	}
	public static void init()
	{
		que.clear();
		for(int i=0; i< 400; i++)
		{
			for(int j=0; j< 400; j++)
			{
				visit[i][j] = -1;
				map[i][j] = 0;
			}
		}
	}
	public static void debug()
	{
		for(int i=158; i<=165; i++)
		{
			for(int j=158; j<= 165; j++)
			{
				System.out.printf("%3d",visit[i][j]);
			}
			System.out.println();
		}
	}
	static class Node {
		int dx, dy, num, state;
		Node(int a, int b, int c, int d){
			dx=a; dy=b; num=c; state=d;
		}
	}
}
