package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	static int K, sdx1, sdy1, sdx2, sdy2 , result, len;
	static int[][] map = new int[10][10];
	static int[] visit = new int[15];
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] dxArr1 = {1, -1}, dyArr1 = {0, 0}; // SN
	static int[] dxArr2 = {0, 0}, dyArr2 = {1, -1}; // EW
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			arr.clear();
			result = INF;
			len = K - 1;
			for(int i=1; i<= K; i++) visit[i] = 0;
			for(int i=1; i<= 5; i++)
			{
				for(int j=1; j<= 5; j++)
				{
					map[i][j] = 0;
				}
			}
			int dx1 = 0, dy1=0, dx2 =0, dy2 =0;
			char type = 0;
			for(int i=1; i<= K; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx1 = Integer.parseInt(st.nextToken());
				dy1 = Integer.parseInt(st.nextToken());
				type = st.nextToken().charAt(0);
				
				if(type == 'E')
				{
					dx2 = dx1;
					dy2 = dy1 - 1;
				}
				else if(type == 'S')
				{
					dx2 = dx1 - 1;
					dy2 = dy1;
				}
				else if(type == 'N')
				{
					dx2 = dx1 + 1;
					dy2 = dy1;
				}
				else if(type == 'W')
				{
					dx2 = dx1;
					dy2 = dy1 + 1;
				}
				if(i == 1)
				{
					sdx1 = dx1; sdy1 = dy1; sdx2 = dx2; sdy2 = dy2;
				}
				else arr.add(new Node(dx1, dy1, dx2, dy2, type));
				map[dx1][dy1] = 1;
				map[dx2][dy2] = 1;
			}
			
			solve(1);
			if(result == INF) bw.write("#"+k+" "+-1+"\n");
			else bw.write("#"+k+" "+result+"\n");
		}
		bw.flush();
	}
	public static void solve(int cnt)
	{
		/*
		int check =0;
		for(int i=1; i<= 5; i++)
		{
			for(int j=1; j<=5; j++)
			{
				System.out.print(map[i][j]+" ");
				if(map[i][j] == 1) check++;
			}
			System.out.println();
		}
		System.out.println(check);
		System.out.println();
		*/
		if(cnt >= result) return; // 가지치기 
		if(map[3][3] == 0 && map[3][4] == 0 && map[3][5] == 0) // clear 
		{
			//System.out.println("//"+cnt);
			result = min(result, cnt);
			return;
		}
		int dx1=0, dy1=0, dx2=0, dy2=0, rdx1=0, rdy1=0, rdx2=0, rdy2=0;
		char type = 0;
		for(int i=0; i< len; i++)
		{
			if(visit[i] == 1) continue; 
			dx1 = rdx1 = arr.get(i).dx1;
			dy1 = rdy1 = arr.get(i).dy1;
			dx2 = rdx2 = arr.get(i).dx2;
			dy2 = rdy2 = arr.get(i).dy2;
			type = arr.get(i).type;
			
			visit[i] = 1;
			map[dx1][dy1] = 0;
			map[dx2][dy2] = 0;
			rdx1 = dx1; rdx2 = dx2; rdy1 = dy1; rdy2 = dy2; // 복귀 
			if(type == 'S' || type == 'N')
			{
				for(int k = 0; k< 3; k++)
				{
					rdx1 += dxArr1[0];
					rdy1 += dyArr1[0];
					rdx2 += dxArr1[0];
					rdy2 += dyArr1[0];
					if(!isRange(rdx1, rdy1) || !isRange(rdx2, rdy2) || map[rdx1][rdy1] == 1 || map[rdx2][rdy2]== 1) break;
					map[rdx1][rdy1] = 1;
					map[rdx2][rdy2] = 1;
					solve(cnt+1);
					map[rdx1][rdy1] = 0;
					map[rdx2][rdy2] = 0;
				}
				rdx1 = dx1; rdx2 = dx2; rdy1 = dy1; rdy2 = dy2; // 복귀
				for(int k = 0; k< 3; k++)
				{
					rdx1 += dxArr1[1];
					rdy1 += dyArr1[1];
					rdx2 += dxArr1[1];
					rdy2 += dyArr1[1];
					if(!isRange(rdx1, rdy1) || !isRange(rdx2, rdy2) || map[rdx1][rdy1] == 1 || map[rdx2][rdy2]== 1) break;
					map[rdx1][rdy1] = 1;
					map[rdx2][rdy2] = 1;
					solve(cnt+1);
					map[rdx1][rdy1] = 0;
					map[rdx2][rdy2] = 0;
				}
			}
			else if(type == 'W' || type == 'E')
			{
				for(int k = 0; k< 3; k++)
				{
					rdx1 += dxArr2[0];
					rdy1 += dyArr2[0];
					rdx2 += dxArr2[0];
					rdy2 += dyArr2[0];
					if(!isRange(rdx1, rdy1) || !isRange(rdx2, rdy2) || map[rdx1][rdy1] == 1 || map[rdx2][rdy2]== 1) break;
					map[rdx1][rdy1] = 1;
					map[rdx2][rdy2] = 1;
					solve(cnt+1);
					map[rdx1][rdy1] = 0;
					map[rdx2][rdy2] = 0;
				}
				rdx1 = dx1; rdx2 = dx2; rdy1 = dy1; rdy2 = dy2; // 복귀
				for(int k = 0; k< 3; k++)
				{
					rdx1 += dxArr2[1];
					rdy1 += dyArr2[1];
					rdx2 += dxArr2[1];
					rdy2 += dyArr2[1];
					if(!isRange(rdx1, rdy1) || !isRange(rdx2, rdy2) || map[rdx1][rdy1] == 1 || map[rdx2][rdy2]== 1) break;
					map[rdx1][rdy1] = 1;
					map[rdx2][rdy2] = 1;
					solve(cnt+1);
					map[rdx1][rdy1] = 0;
					map[rdx2][rdy2] = 0;
				}
			}
			
			visit[i] = 0;
			map[dx1][dy1] = 1;
			map[dx2][dy2] = 1;
		}
	}
	public static boolean isRange(int dx, int dy) 
	{
		return dx >=1 && dy >= 1 && dx <= 5 && dy <= 5;
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int min(int a, int b) { return a > b ? b : a; }
	static class Node{
		int dx1, dy1, dx2, dy2;
		char type;
		Node(int a, int b, int c, int d, char e) {
			dx1 = a; dy1 = b; dx2 = c; dy2 = d; type = e;
		}
	}
}


/**
3
8
3 2 E
2 4 S
3 4 N
1 2 N
4 5 S
1 1 N
5 3 S
5 4 W
5
3 2 E
2 2 E
3 4 N
2 5 N
1 2 E
9
3 2 E
3 3 S
4 4 S
1 2 E
1 5 E
5 1 W
5 4 E
4 1 W
3 5 S
 */
