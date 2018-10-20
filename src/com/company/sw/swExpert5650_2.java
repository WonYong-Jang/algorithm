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
 * 핀볼 게임 
 */
public class swExpert5650_2 {

	static int N, ans, sdx, sdy;
	static int[][] map = new int[105][105];
	static int[][] warm = new int[11][4]; // 6 ~ 10 인덱스 사용 
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0 ,1, 0, -1};
	static int[] back = {2, 3, 0, 1};
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
			int num = 0;
			init(); // 초기화 
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					if(num >=6 && num <= 10) { // 웜홀 인덱스 저장 
						if(warm[num][0] == 0) {
							warm[num][0] = i; warm[num][1] = j; 
						}
						else {
							warm[num][2] = i; warm[num][3] = j;
						}
					}
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(map[i][j] == 0)
					{
						que.clear();
						sdx = i; sdy = j;
						for(int a=0; a<4; a++)
						{
							int nx = i + dxArr[a];
							int ny = j + dyArr[a];
							que.add(new Node(nx, ny, a, 0));
						}
						solve(); // 확인 
					}
				}
			}
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			Node n = que.poll();
			int nx = 0, ny =0;
			if(!isRange(n.dx, n.dy))
			{
				nx = n.dx - dxArr[n.dir]; // 뒤로 후진 
				ny = n.dy - dyArr[n.dir];
				que.add(new Node(nx, ny, back[n.dir], n.cnt+1));
			}
			else if((n.dx == sdx && n.dy ==sdy) || map[n.dx][n.dy] == -1)
			{
				ans = max(ans, n.cnt);
				continue;
			}
			else if(map[n.dx][n.dy] == 0)
			{
				nx = n.dx + dxArr[n.dir];
				ny = n.dy + dyArr[n.dir];
				que.add(new Node(nx, ny, n.dir, n.cnt));
			}
			else if(map[n.dx][n.dy] >= 1 && map[n.dx][n.dy] <= 5)
			{
				int next = direction(map[n.dx][n.dy], n.dir);
				nx = n.dx + dxArr[next];
				ny = n.dy + dyArr[next];
				que.add(new Node(nx, ny, next, n.cnt+1));
			}
			else if(map[n.dx][n.dy] >= 6 && map[n.dx][n.dy] <= 10)
			{
				int target = map[n.dx][n.dy];
				if(warm[target][0] == n.dx && warm[target][1] == n.dy) {
					nx = warm[target][2] + dxArr[n.dir];
					ny = warm[target][3] + dyArr[n.dir];
				}
				else {
					nx = warm[target][0] + dxArr[n.dir];
					ny = warm[target][1] + dyArr[n.dir];
				}
				que.add(new Node(nx, ny, n.dir, n.cnt));
			}
		}
	}
	public static int direction(int block, int dir)
	{
		int next = 0;
		if(block == 1)
		{
			if(dir ==0) next =2;
			else if(dir == 1) next =3;
			else if(dir == 2) next =1;
			else if(dir == 3) next =0;
		}
		else if(block == 2)
		{
			if(dir == 0) next =1;
			else if(dir == 1) next =3;
			else if(dir == 2) next =0;
			else if(dir == 3) next =2;
		}
		else if(block == 3)
		{
			if(dir == 0) next = 3;
			else if(dir == 1) next =2;
			else if(dir == 2) next =0;
			else if(dir == 3) next =1;
		}
		else if(block == 4)
		{
			if(dir == 0) next =2;
			else if(dir == 1) next =0;
			else if(dir == 2) next =3;
			else if(dir == 3) next =1;
		}
		else if(block == 5)
		{
			if(dir == 0) next =2;
			else if(dir == 1) next =3;
			else if(dir == 2) next =0;
			else if(dir == 3) next =1;
		}
		return next;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= N;
	}
	public static void init()
	{
		sdx = sdy = 0;
		ans = 0;
		for(int i=6; i<= 10; i++)
			for(int j=0; j<4; j++)
				warm[i][j] = 0;
	}
	static class Node{
		int dx, dy, dir, cnt;
		Node(int a, int b, int c, int d) {
			dx=a; dy=b;dir=c;cnt=d;
		}
	}
}
