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
 * 아기 상어 
 */
public class baek16236 {

	static int N;
	static int[][] map = new int[25][25];
	static int[][] visit = new int[25][25];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static Queue<Node> que = new LinkedList<>();
	static PriorityQueue<Node> target = new PriorityQueue<>(new mySort());
	static int sdx, sdy, size, cnt, result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sdx = sdy = cnt = result = 0;
		size = 2; // 기본 아기 상어 사이즈 
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 9) { // 아기 상어 처음 위치 
					sdx = i; sdy = j;
				}
			}
		}
		solve();
		System.out.println(result);
	}
	public static void solve()
	{
		boolean flag = true;
		
		while(true)
		{
			if(!flag) break;
			flag = false;
			
			while(!target.isEmpty()) // 아기 상어가 다음으로 갈 위치 선정 
			{
				map[sdx][sdy] = 0; // 전에 상어 위치 제거 
				Node n = target.poll();
				map[n.dx][n.dy] = 9; // 아기 상어 자리 
				cnt++;
				sdx = n.dx;
				sdy = n.dy;
				result += n.dis;
				//System.out.println(sdx+" "+ sdy+" "+n.size+" "+n.dis);
				break;
			}
			
			if(cnt == size) // 사이즈만큼 먹었으면 사이즈 증가 
			{
				size++;
				cnt = 0;
			}
			init(); // 방문 배열 초기화 
			
			que.clear(); target.clear();
			que.add(new Node(sdx,sdy, size, 0));
			visit[sdx][sdy] = 1;
			while(!que.isEmpty())
			{
				Node n = que.poll();
				
				for(int i=0; i<4; i++)
				{
					int nx = n.dx + dxArr[i];
					int ny = n.dy + dyArr[i];
					if(!isRange(nx, ny) || visit[nx][ny]== 1 || n.size < map[nx][ny]) continue;
					
					if(n.size > map[nx][ny] && (map[nx][ny] >= 1 && map[nx][ny] <= 6) )
					{
						target.add(new Node(nx, ny, n.size, n.dis+1));
						flag = true;
					}
					que.add(new Node(nx,ny,n.size, n.dis+1));
					visit[nx][ny] = 1;
				}
				
			}
		}
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= N;
	}
	public static void init()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	static class Node{
		int dx, dy, size, dis;
		Node(int a, int b, int c, int d) {
			dx =a; dy = b; size = c; dis = d; 
		}
	}
	static class mySort implements Comparator<Node>{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.dis < b.dis) return -1;
			else if(a.dis > b.dis) return 1;
			else { // size 같으면 
				if(a.dx < b.dx) return -1;
				else if(a.dx > b.dx) return 1;
				else { // dx 값도 같은 라인이면 더 왼쪽에 있는 값 
					if(a.dy < b.dy) return -1;
					else if(a.dy > b.dy) return 1;
					else return 0;
				}
				
			}
		}
		
	}
}










