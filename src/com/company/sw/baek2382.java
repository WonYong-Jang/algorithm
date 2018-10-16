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
 * 미생물 격리 
 */
public class baek2382 {

	static int N, M, K, ans;
	static int[][][] map = new int[2][105][105];
	static int[] dxArr = {0,-1, 1, 0, 0}, dyArr = {0, 0, 0, -1, 1}; // 북 남 서 동 
	static int[] back = {0, 2, 1, 4, 3};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			que.clear();
			int dx=0, dy=0, num=0, dir=0;
			for(int i=0; i< K; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				num = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				que.add(new Node(dx, dy, num, dir));
			}
			solve();
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		int min=0, len =0;
		while(!que.isEmpty())
		{
			len = que.size();
			min++;
			for(int i=0; i< len; i++)
			{
				Node n = que.poll();
				int curDir = n.dir, num = n.num;
				int nx = n.dx + dxArr[curDir];
				int ny = n.dy + dyArr[curDir];
				if(!isRange(nx, ny)) 
				{
					curDir = back[curDir];
					num /= 2;
					if(num ==0) continue;
				}
				if(map[0][nx][ny] ==0)
				{
					map[0][nx][ny] = num;
					map[1][nx][ny] = num;
				}
				else if(map[0][nx][ny] > 0)
				{
					map[0][nx][ny] = max(map[0][nx][ny] , num);
					map[1][nx][ny] += num;
				}
				que.add(new Node(nx,ny,num,curDir));
			}
			
			len = que.size();
			for(int i=0; i< len; i++)
			{
				Node n = que.poll();
				
				if(map[0][n.dx][n.dy] != n.num) continue;
				que.add(new Node(n.dx, n.dy, map[1][n.dx][n.dy],n.dir));
				map[0][n.dx][n.dy] = 0;
				map[1][n.dx][n.dy] = 0;
			}
			
			if(min == M) 
			{
				len = que.size();
				for(int i=0; i<len; i++)
				{
					Node n = que.poll();
					ans += n.num;
				}	
				break;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx < N-1 && dy < N-1;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	static class Node {
		int dx, dy, num, dir;
		Node(int a, int b, int c, int d) {
			dx=a; dy=b; num=c; dir=d;
		}
	}
}





