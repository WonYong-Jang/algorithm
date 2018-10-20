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
 * 벽돌 깨기 
 */
public class baek5656 {

	static int N, H, W, ans;
	static int[][] map = new int[20][20];
	static int[][][] originMap = new int[5][20][20];
	static int[][] visit = new int[20][20];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static Queue<Node> que = new LinkedList<>();
	static Queue<Integer> temp = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			ans = 500000;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			for(int i=1; i<= H; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= W; j++)
				{
					int num = Integer.parseInt(st.nextToken());
					originMap[0][i][j] = map[i][j] = num;
				}
			}
			
			solve(0);
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int depth)
	{	
		if(depth == N)
		{
			int sum =0;
			for(int i=1; i<= H; i++)
			{
				for(int j=1; j<= W; j++)
				{
					if(map[i][j] > 0) sum++;
				}
			}
			ans = min(ans, sum);
			return;
		}
		
		for(int i=1; i<= H; i++)
			for(int j=1; j<= W; j++)
				originMap[depth][i][j] = map[i][j];
		
		for(int i=1; i<= W; i++)
		{
			collision(i);
			solve(depth+1);
			init(depth);
		}
	}
	public static void collision(int col)
	{
		for(int i=1; i<= H; i++)
		{
			if(map[i][col] > 0) {
				go(i, col); break;
			}
		}
	}
	public static void go(int dx, int dy)
	{
		for(int i=1; i<= H; i++)
		{
			for(int j=1; j<= W; j++)
			{
				visit[i][j] = 0;
			}
		}
		que.clear();
		que.add(new Node(dx, dy, map[dx][dy]));
		visit[dx][dy] = 1;
		map[dx][dy] = 0;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int k=1; k<= n.num-1; k++)
			{
				for(int i=0; i<4; i++)
				{
					int nx = n.dx + dxArr[i]*k;
					int ny = n.dy + dyArr[i]*k;
					if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
					if(map[nx][ny] > 0 ) {
						que.add(new Node(nx, ny, map[nx][ny]));
						map[nx][ny] = 0;
					}
				}
			}
		}
		down();
	}
	public static void down()
	{
		
		for(int i=1; i<= W; i++)
		{
			temp.clear();
			for(int j= H; j >= 1 ; j--)
			{
				if(map[j][i] > 0 ) {
					temp.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			int index = H;
			while(!temp.isEmpty())
			{
				int num = temp.poll();
				map[index][i] = num;
				index--;
			}
		}
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= H && dy<= W;
	}
	public static void init(int depth)
	{
		for(int i=1; i<= H; i++)
		{
			for(int j=1; j<= W; j++)
			{
				map[i][j] = originMap[depth][i][j];
			}
		}
	}
	public static void debug()
	{
		for(int i=1; i<= H; i++)
		{
			for(int j=1; j<= W; j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy, num;
		Node(int a, int b, int c){
			dx=a; dy=b; num =c;
		}
	}
}
