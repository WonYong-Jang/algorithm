package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백조의 호수 
 */
public class baek3197 {

	static int R, C, ans;
	static int sdx, sdy, edx, edy;
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static char[][] map = new char[1505][1505]; // input 
	static int[][] visit = new int[1505][1505]; //
	static int[][] predict = new int[1505][1505]; // 미리 녹는 날짜 계산 
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int flag = 0;
		ans =0;
		for(int i=1; i<= R; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= C; j++)
			{
				char temp = str.charAt(j-1);
				map[i][j] = temp;
				if(temp == '.' || temp == 'L') { // 백조에서 부터도 녹을 수 있기 때문 
					que.add(new Node(i,j));
					visit[i][j] = 1;
				}
				if(temp == 'L') // 백조 위치 기록 
				{
					if(flag ==0) {
						sdx = i; sdy = j; flag++;
					}
					else {
						edx = i; edy = j;
					}
				}
			}
		}
		
		int e = predict(); // 최대 많이 걸리는 값이 리턴됨 
		int s = 0;
		
		while(s <= e) // 이분 검색 
		{
			int mid = (s+e) /2;
			if(checkBfs(mid)) { // 정답 가능성 , 더 빠른 시간이 있는지 확인  
				ans = mid;
				e = mid-1;
			}
			else { // 불가능 / 시간 올리기 
				s = mid+1;
			}
		}
		
		System.out.println(ans);
	}
	public static boolean checkBfs(int min) // 해당 시간에 백조가 만날수 있는지 확인 
	{
		boolean flag = false;
		que.clear();
		init(); // 방문 배열 초기
		
		que.add(new Node(sdx, sdy)); // 시작 백조 위치 
		visit[sdx][sdy] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			if(n.dx == edx && n.dy == edy) {
				flag = true;
				break;
			}
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1 || predict[nx][ny] > min) continue;
				visit[nx][ny] = 1;
				que.add(new Node(nx, ny));
			}
		}
		
		return flag;
	}
	public static int predict() // 미리 녹는 날짜 계산 
	{
		int min = 1; 
		while(!que.isEmpty())
		{
			int len = que.size();
			
			for(int i=0; i< len; i++)
			{
				Node n = que.poll();
				
				for(int k=0; k<4; k++)
				{
					int nx = n.dx+ dxArr[k];
					int ny = n.dy+ dyArr[k];
					if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
					
					predict[nx][ny] = min;
					visit[nx][ny] = 1;
					que.add(new Node(nx, ny));
					
				}
			}
			min++; // 시간 늘려주기 
		}
		// 3초가 최대라고 했을때 predict 배열에 3을 찍어주고 시간은 4인 상태로 큐에 삽입
		// 그 후 주변에 모두 녹아서 갈곳이 없으므로 min = 5 가 되고 종료 되므로 최종 결과값에 -2 
		return min-2;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<=R && dy<=C;
	}
	public static void init()
	{
		for(int i=1; i<= R; i++)
			for(int j=1; j<= C; j++)
				visit[i][j] = 0;
	}
	public static void debug()
	{
		for(int i=1; i<= R; i++)
		{
			for(int j=1; j<= C; j++)
			{
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static class Node{
		int dx, dy;
		Node(int a, int b) {
			dx =a; dy =b;
		}
	}
}