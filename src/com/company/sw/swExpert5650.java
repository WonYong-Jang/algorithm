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
 * 핀볼 게임 [ 모의 SW 역량테스트 ]
 */
public class swExpert5650 {

	static int N, ans , sdx, sdy;  // ans : 정답 변수, 시작점 : (sdx, sdy)
	static int[][] map = new int[105][105];
	static int[][] hole = new int[11][4]; // 번호 에 해당하는 2쌍의 좌표 기록 배열 (warmHole)  6 ~ 10
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1}; // 북 동 남 서
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		int temp = 0;
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			init(); // 초기화 
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if(temp >= 6) // 웜홀 
					{
						int index =0;
						if(hole[temp][index] ==0) // 웜홀 쌍 기록 
						{
							hole[temp][index] = i; 
							hole[temp][index+1] = j;
						}
						else {
							index +=2 ;
							hole[temp][index] = i; 
							hole[temp][index+1]= j;
						}
					}
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					que.clear();
					for(int m=0; m<4; m++)
					{
						if(map[i][j] == 0) // 0 이면 시작점 놓고 검사 
						{
							sdx = i; sdy = j; // 시작점 지정 하고 시작
							int nx = sdx + dxArr[m]; // 시작점으로부터 4방향 큐에 넣고 시작 
							int ny = sdy + dyArr[m];
							que.add(new Node(nx, ny, m, 0));
							solve();
						}
					}
				}
			}
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		int nx =0, ny = 0, nextDir = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			nextDir = n.dir;
			nx = n.dx + dxArr[nextDir];
			ny = n.dy + dyArr[nextDir];
			
			if(!isRange(n.dx, n.dy)) {  // 범위 넘게 되면 
				nextDir = (nextDir + 2 ) % 4; // 반대 방향 바꿔주기
				nx = n.dx + dxArr[nextDir];
				ny = n.dy + dyArr[nextDir];
				que.add(new Node(nx, ny, nextDir, n.cnt+1)); // 카운트 +1
			}
			else if(map[n.dx][n.dy] == -1 || (sdx == n.dx && sdy == n.dy)) // 블랙홀 이거나 시작점 돌아왔을 경우 
			{
				ans = max(ans, n.cnt);
				continue;
			}
			else if(map[n.dx][n.dy] ==0 ) // 0이면 방향 그대로 진행 
			{
				que.add(new Node(nx, ny, nextDir, n.cnt));
			}
			else if(map[n.dx][n.dy] >= 1 && map[n.dx][n.dy] <= 5) // 벽돌 부딛힌 경우 턴 
			{
				nextDir = direction(map[n.dx][n.dy], nextDir);
				nx = n.dx + dxArr[nextDir];
				ny = n.dy + dyArr[nextDir];
				que.add(new Node(nx, ny, nextDir, n.cnt+1)); // 카운트 +1 
			}
			else if(map[n.dx][n.dy] >= 6 && map[n.dx][n.dy] <= 10) // 웜홀 
			{
				int temp = map[n.dx][n.dy];
				if(hole[temp][0] == n.dx && hole[temp][1] == n.dy) { // 연결된 웜홀 위치 찾아 주기 
					n.dx = hole[temp][2]; n.dy = hole[temp][3];
				}
				else {
					n.dx = hole[temp][0]; n.dy = hole[temp][1];
				}
				nx = n.dx + dxArr[nextDir];
				ny = n.dy + dyArr[nextDir];
				que.add(new Node(nx, ny, nextDir, n.cnt));
			}
		}
	}
	public static int direction(int num, int dir) // 1 ~ 5
	{
		int nextDir = 0;
		
		switch(num) // 방향 전환 
		{
		case 1:
			if(dir==0) nextDir=2;
			else if(dir==1) nextDir=3;
			else if(dir==2) nextDir=1;
			else if(dir==3) nextDir=0;
			break;
		case 2:
			if(dir==0) nextDir=1;
			else if(dir==1) nextDir=3;
			else if(dir==2) nextDir=0;
			else if(dir==3) nextDir=2;
			break;
		case 3:
			if(dir==0) nextDir=3;
			else if(dir==1) nextDir=2;
			else if(dir==2) nextDir=0;
			else if(dir==3) nextDir=1;
			break;
		case 4:
			if(dir==0) nextDir=2;
			else if(dir==1) nextDir=0;
			else if(dir==2) nextDir=3;
			else if(dir==3) nextDir=1;
			break;
		case 5:
			if(dir==0) nextDir=2;
			else if(dir==1) nextDir=3;
			else if(dir==2) nextDir=0;
			else if(dir==3) nextDir=1;
			break;
		}
		
		return nextDir;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void init()
	{
		ans = 0;
		for(int i=6; i<= 10; i++) // 웜홀 6 ~ 10 초기화 
		{
			for(int j=0; j<4; j++)
			{
				hole[i][j] = 0;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= N;
	}
	static class Node {
		int dx, dy, dir, cnt; 
		Node(int a, int b, int c, int d) {
			dx=a; dy=b; dir=c; cnt=d;
		}
	}
}
