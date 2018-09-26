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
public class swExpert5656 {

	static int N, W, H, ans, breakCnt; // (H, W)
	static int[][][] originMap = new int[5][20][20];
	static int[][] tempMap = new int[20][20];
	static int[][] visit = new int[20][20];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>(); // 블록 깨트릴 때 사용할 큐 
	static Queue<Integer> tQue = new LinkedList<>(); // 블록들 밑으로 내릴때 사용할 temp 큐 
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
			W = Integer.parseInt(st.nextToken()); // 반대 입력 받기 
			H = Integer.parseInt(st.nextToken());
			ans = breakCnt = 0;
			int temp = 0;
			for(int i=1; i<= H; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= W; j++)
				{
					temp = Integer.parseInt(st.nextToken());
					tempMap[i][j] = temp;
					if(temp > 0) ans++; // 현재 벽돌 갯수 세어주기 
				}
			}

			solve(0, 0);
			int result = ans - breakCnt;
			bw.write("#"+k+" "+result+"\n");
		}
		bw.flush();
	}
	public static void solve(int curSize, int cnt)
	{
		if(curSize == N)
		{
			if(breakCnt < cnt)
			{
				breakCnt = cnt;
			}
			return;
		}
		for(int i=1; i<= H; i++)
			for(int j=1; j<= W; j++)
				originMap[curSize][i][j] = tempMap[i][j]; // 원본 맵 저장 
		
		for(int i=1; i<= W; i++)
		{
			int sum = go(i); // 해당 열에 벽돌 떨궈보면서 검사 시작 
			
			solve(curSize+1, cnt + sum);
			
			init(curSize); // 원본 맵으로 다시 바꿔서 다음 검사를 위해 
		}
		
	}
	public static int go(int col) // 해당 열 기준으로 벽돌 깨기 시작 
	{
		int breakWall = 0;
		
		for(int i=1; i<= H; i++)
			for(int j=1; j<= W; j++)
				visit[i][j] = 0;
		que.clear();
		for(int i=1; i<= H; i++)
		{
			if(tempMap[i][col] > 0) // 해당 열 내려가면서 0이상인점 시작점으로 지정  
			{
				que.add(new Node(i, col, tempMap[i][col], -1));
				visit[i][col] = 1; // 방문 체크 
				tempMap[i][col] = 0; // 0으로 만들기 
				breakWall++; // 부순 벽돌 갯수 
				break;
			}
		}
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dir == -1) // 방향 설정이 되어 있지 않은 경우  
			{
				int scope = n.cnt - 1; // 4방향 얼마나 가야하는지 ( 벽돌 적인 숫자 -1 )
				if(scope > 0)
				{
					for(int i=0; i<4; i++)
					{
						int nx = n.dx + dxArr[i];
						int ny = n.dy + dyArr[i];
						if(!isRange(nx, ny)) continue;
						if(visit[nx][ny] == 0 && tempMap[nx][ny] > 0) { // 방문하지 않은점 큐에 넣고 또 4방향 돌려보기 
							que.add(new Node(nx, ny, tempMap[nx][ny], -1));
							tempMap[nx][ny] = 0;
							visit[nx][ny] = 1;
							breakWall++;
						}
						que.add(new Node(nx, ny, scope - 1, i));  // scope 값만큼 이동해보기 
					}
				}
			}
			else if(n.dir != -1) // 방향이 정해진 경우 
			{
				if(n.cnt > 0) // 해당 방향으로 더 가볼수 있는 경우 
				{
					int nx = n.dx + dxArr[n.dir];
					int ny = n.dy + dyArr[n.dir];
					if(!isRange(nx, ny)) continue;
					if(visit[nx][ny] ==0 && tempMap[nx][ny] > 0) { // 방문하지 않은점 큐에 넣고 또 4방향 돌려보기 
						que.add(new Node(nx, ny, tempMap[nx][ny], -1));
						tempMap[nx][ny] = 0;
						visit[nx][ny] = 1;
						breakWall++;
					}
					que.add(new Node(nx, ny, n.cnt - 1, n.dir));  // scope 값만큼 이동해보기
				}
			}
			
		}
		
		tQue.clear();
		
		for(int i=1; i<= W; i++)
		{
			for(int j = H; j >= 1; j--)
			{
				if(tempMap[j][i] > 0) { // 0 아닌값 다 큐에 넣어 두기 
					tQue.add(tempMap[j][i]);
					tempMap[j][i] = 0;
				}
			}
			
			int index = H;
			
			while(!tQue.isEmpty()) // 남은 블록 밑으루 다 내리기 
			{
				int num = tQue.poll();
				
				tempMap[index][i] = num;
				index--;
			}
		}
		
		return breakWall;
	}
	public static void init(int index)
	{
		for(int i=1; i<= H; i++)
			for(int j=1; j<= W; j++)
				tempMap[i][j] = originMap[index][i][j];
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx <= H && dy <= W;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void debug()
	{
		System.out.println();
		for(int i=1; i<= H; i++)
		{
			for(int j=1; j<= W; j++)
			{
				System.out.print(tempMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static class Node{
		int dx, dy, cnt, dir; // dir 방향 지정 , -1 인경우 방향이 지정되지 않은 상태 4방향 확인 
		Node(int a, int b, int c, int d) {
			dx = a; dy = b; cnt = c; dir = d;
		}
	}
}
