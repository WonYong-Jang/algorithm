package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 무선 충전 
 */
public class swExpert5644 {

	static int M, A, ans; // 총 이동 시간, bc 의 갯수 
	static int sdx, sdy, edx, edy;
	static int[][] map = new int[12][12];
	static int[][] visit = new int[12][12];
	static int[][] bc = new int[9][4]; // 0 ~ 7 // ( 0, 1 ) 좌표 , 2 : 범위 , 3: 성능 
	static int[] dxArr = {0, -1, 0, 1, 0}, dyArr = {0, 0, 1, 0, -1}; // 북 동 남 서 
	static int[][] path = new int[2][105]; // a ,b 이동 경로 저장 
	static Queue<Node> que = new LinkedList<>(); // bc 범위 표시 하기위한 큐 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			 
			init(); // 시작전 초기화 
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=1; i<= M; i++)
			{
				path[0][i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= M; i++)
			{
				path[1][i] = Integer.parseInt(st.nextToken());
			}
			
			int dx, dy, c, p; // bc 입력 
			for(int i=0; i< A; i++)
			{
				st = new StringTokenizer(br.readLine());
				dy = Integer.parseInt(st.nextToken());
				dx = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				bc[i][0] = dx; bc[i][1] = dy; bc[i][2] = c; bc[i][3] = p;
				
				int value = (1 << i); // 비트 마스크 기록하기 위한 값 
				setScope(dx, dy, c, value); // bc 마다 범위 설정 ( map 에 그려줌 ) 
			}
			
			for(int i=0; i<= M; i++)
			{
				solve(i); // 0 초부터 돌려 
			}	
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int time)
	{
		sdx = sdx + dxArr[path[0][time]];
		sdy = sdy + dyArr[path[0][time]]; // 사용자 1
		edx = edx + dxArr[path[1][time]];
		edy = edy + dyArr[path[1][time]]; // 사용자 2
		
		ArrayList<Integer> sArr = new ArrayList<>(); // 사용자 1 의 가능한 bc 인덱스 배열 
		ArrayList<Integer> eArr = new ArrayList<>(); // 사용자 2
		int tempMax =0, sNum =0, eNum =0;
		
		for(int i=0; i< 8; i++)
		{
			if(( map[sdx][sdy] & (1 << i)) > 0) sArr.add(i); // 겹쳐있는 bc 찾아서 저장 
			
			if(( map[edx][edy] & (1 << i)) > 0) eArr.add(i);
		}
		
		if(sArr.size() > 0 && eArr.size() > 0) // 두개 다 0 이상 
		{
			for(int i=0; i< sArr.size(); i++)
			{
				for(int j=0; j< eArr.size(); j++)
				{
					if(sArr.get(i) == eArr.get(j)) { // 같은 bc 를 사용하는 경우 반 나눠 
						sNum = eNum = (bc[sArr.get(i)][3] / 2);
					}
					else {
						sNum = bc[sArr.get(i)][3];
						eNum = bc[eArr.get(j)][3];
					}
					tempMax = max(tempMax, sNum+eNum); // 제일 성능 좋은거 찾기 
				}
			}
		}
		else if(sArr.size() ==0 && eArr.size() > 0) // 두 사용자중 한명만 범위 안에 들어올경우 
		{
			for(int i=0; i< eArr.size(); i++)
			{
				eNum = bc[eArr.get(i)][3];
				tempMax = max(tempMax, eNum); // 제일 성능 좋은거 찾기
			}
		}
		else if(sArr.size() > 0 && eArr.size() == 0) // 두 사용자중 한명만 범위 안에 들어올경우
		{
			for(int i=0; i< sArr.size(); i++)
			{
				sNum = bc[sArr.get(i)][3];
				tempMax = max(tempMax, sNum); // 제일 성능 좋은거 찾기
			}
		}
		ans += tempMax;
		
	}
	public static void setScope(int dx, int dy, int scope, int value) // bc 의 범위를 비트마스크로 표현 
	{
		for(int i=1; i<= 10; i++)
			for(int j=1; j<= 10; j++)
				visit[i][j] = 0;
		que.clear();
		que.add(new Node(dx, dy, 0)); // 범위를 처음 0으로 설정 
		visit[dx][dy] = 1;
		map[dx][dy] += value;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.scope == scope) continue;
			
			for(int i=1; i<= 4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
				map[nx][ny] += value;
				visit[nx][ny] = 1;
				que.add(new Node(nx, ny, n.scope+1));
			}
		}
	}
	public static void init()
	{
		ans = 0;
		sdx = 1; sdy = 1; edx = 10; edy = 10; // 사용자 1, 2  시작 위치 
		path[0][0] = 0; path[1][0] = 0; // 시작점(0초일때) 0으로 초기화
		
		for(int i=0; i<=10; i++)
			for(int j=0; j<= 10; j++)
				map[i][j] = 0;
	}
	public static void debug()
	{
		for(int i=1; i<= 10; i++)
		{
			for(int j=1; j<= 10; j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
			
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx <= 10 && dy <= 10;
	}
	static class Node{
		int dx, dy, scope;
		Node(int a, int b, int c) {
			dx = a; dy = b; scope = c;
		}
	}
}



