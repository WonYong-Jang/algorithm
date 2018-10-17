package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미네랄 
 */
public class baek2933 {

	static int N, M, cmd, cnt;
	static char[][] map = new char[105][105];
	static int[][] visit = new int[105][105];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1}; // 북 동 남 서 
	static Queue<Node> que = new LinkedList<>();
	static ArrayList<Node> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0; // 왼쪽 , 오른쪽 번갈아 던지는 것 카운트 
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				map[i][j] = str.charAt(j-1);
			}
		}
		st = new StringTokenizer(br.readLine());
		cmd = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< cmd; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			
			solve(N - num + 1);
		}
		print();
	}
	public static void solve(int height)
	{
		if(cnt % 2 == 0) { // 왼쪽에서 던질 때 
			for(int i=1; i<= M; i++)
			{
				if(map[height][i] == 'x')
				{
					map[height][i] = '.'; 
					break;
				}	
			}
			cnt++;
		}
		else { // 오른쪽에서 던질 때 
			for(int i=M; i >= 1; i--)
			{
				if(map[height][i] == 'x')
				{
					map[height][i] = '.'; 
					break;
				}
			}
			cnt++;
		}
		init();
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(visit[i][j] == 1) continue;
				if(map[i][j] == 'x')
				{
					if(!check(i,j)) {
						return; // 클러스터 정리 됬다면
					}
				}
			}
		}
	}
	public static boolean check(int dx, int dy)
	{
		int height = -1; // dx 가 N 이라면 땅에 붙어 있음
		arr.clear(); que.clear();
		que.add(new Node(dx, dy));
		visit[dx][dy] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			arr.add(n);
			height = max(height, n.dx); 
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
				if(map[nx][ny] == 'x') {
					visit[nx][ny] = 1;
					que.add(new Node(nx, ny));
				}
			}
		}
		
		if(height == N) return true; // 땅에 붙어 있을 경우 
		else // 허공에 떠있는 경우 정리 한 후 
		{
			int sdx = 0, sdy =0;
			
			for(int i=0; i< arr.size(); i++) // 미리 다 지워 
			{
				sdx = arr.get(i).dx;
				sdy = arr.get(i).dy;
				map[sdx][sdy] = '.';
			}
			
			int down = N; // 몇 칸 내려가야하는지 
			for(int i=0; i< arr.size(); i++) // 내려갈 공간 찾아 
			{
				sdx = arr.get(i).dx;
				sdy = arr.get(i).dy;
				boolean flag = false;
				int cnt = 0; 
				for(int j = sdx+1; j<= N; j++)
				{
					if(map[j][sdy] == 'x') 
					{	
						down = min(down, cnt);
						flag = true;
						break;
					}
					cnt++;
				}
				if(!flag) down = min(down, cnt);
			}
			
			
			for(int i=0; i< arr.size(); i++) // 중력 작용  
			{
				sdx = arr.get(i).dx + down;
				sdy = arr.get(i).dy;
				map[sdx][sdy] = 'x';
			}
			
			return false; 
		}
	}
	public static void init()
	{
		arr.clear();
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	public static void print()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b){
			dx=a; dy=b;
		}
	}
}

/**
9 11 
..xxxxxxxx.
..x......x. 
..x......x. 
..x..xxxxx. 
..x......x. 
..x......x. 
..x......x. 
..xxx....x. 
x........x.
2
1 7
 */


