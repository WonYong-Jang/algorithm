package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 퍼즐 
 */
public class baek1525 {

	static String answer, start;
	static int sdx, sdy, result;
	static int[][] map = new int[4][4];
	static HashSet<String> set = new HashSet<>();
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = 0;
		start ="";
		result = -1;
		for(int i=1; i<=3; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++)
			{
				num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 0) {
					sdx = i; sdy = j;
				}
				start += num;
			}
		}
		
		answer = "";
		for(int i=1; i<= 8; i++)
		{
			answer += i;
		}
		answer += 0;
	
		solve();
		System.out.println(result);
	}
	public static void solve()
	{
		Node stt = new Node(sdx,sdy,0,map);
		stt.str = start;
		que.add(stt);
		set.add(start);
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			int[][] temp = new int[4][4];
			if(answer.equals(n.str)) {
				result = n.cnt;
				break;
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny)) continue;
				
				
				for(int a=1; a<=3; a++)
					for(int b=1; b<=3; b++)
						temp[a][b] = n.arr[a][b];
				
				int tmp = temp[nx][ny];
				temp[nx][ny] = 0;
				temp[n.dx][n.dy] = tmp;
				
				String stmp = "";
				for(int a=1; a<=3; a++)
					for(int b=1; b<=3; b++)
						stmp += temp[a][b];
				
				if(set.contains(stmp)) continue;
				
				Node cur = new Node(nx, ny, n.cnt+1, temp);
				cur.str = stmp;
				set.add(stmp);
				que.add(cur);
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx<= 3 && dy<= 3;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy, cnt;
		String str;
		int[][] arr = new int[4][4];
		Node(int a, int b, int c, int[][] d)
		{
			dx=a; dy=b; cnt=c;
			for(int i=1; i<=3; i++)
				for(int j=1; j<=3; j++)
					arr[i][j] = d[i][j];
			str = "";
		}
	}
}
