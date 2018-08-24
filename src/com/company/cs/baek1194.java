package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 달이 차오른다, 가자 ( 비트 마스크 ==> 키를 가지고 있는 수만큼 비트 마스킹 계산후 검사 ) 
 */
public class baek1194 {

	static int N, M, dx, dy; // 시작점 
	static Queue<Node> que = new LinkedList<>();
	static char[][] map = new char[51][51];
	static int[][][] visit = new int[51][51][64]; //  32, 16, 8, 4, 2, 1 ( 6개의 키 2진수로 표현 )
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				char temp = str.charAt(j-1);
				map[i][j] = temp;
				if(temp == '0') 
				{
					dx = i; dy = j; // 시작점 고정  
				}
			}
		}
		solve();
	}
	public static void solve()
	{
		que.add(new Node(dx, dy, 0)); // key 를 가지고 있지 않을 때 0  
		visit[dx][dy][0] = 1; // 1에서 시작했으니 마지막에 1빼주기 ! 
		while(!que.isEmpty())
		{
			Node n = que.poll();
			int keys = n.keys;
			
			if(map[n.dx][n.dy] == '1') { // 최단거리 도착 
				System.out.println(visit[n.dx][n.dy][n.keys]-1);
				return;
			}
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
			
				if(!isRange(nx, ny) || visit[nx][ny][n.keys] > 0 || map[nx][ny] == '#') continue;
				if( map[nx][ny] >= 'a' && map[nx][ny] <= 'f' ) // 열쇠 찾았을 때 ! 
				{
					int bit = 1 << map[nx][ny] - 'a';
					keys |= bit; // or 연산자 이용해서 가진 key 합치기 
					
					visit[nx][ny][keys] = visit[n.dx][n.dy][n.keys] + 1;
					que.add(new Node(nx, ny, keys));
				}
				else if( map[nx][ny] >= 'A' && map[nx][ny] <= 'F' )
				{
					int bit = 1 << map[nx][ny] - 'A';
					int bitMask = keys & bit; 
					if(bitMask > 0) // 현재 가진 키중에서 문 통과할수 있는 키 찾기
					{
						visit[nx][ny][n.keys] = visit[n.dx][n.dy][n.keys] + 1;
						que.add(new Node(nx,ny, n.keys));
					}
				}
				else { // 그외 .  0  1 모두 이동 가능 ! 
					visit[nx][ny][n.keys] = visit[n.dx][n.dy][n.keys] + 1;
					que.add(new Node(nx,ny, n.keys));
				}
			}
		}
		System.out.println(-1);
	}
	public static boolean isRange(int dx, int dy) 
	{
		return dx >=1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy, keys; // keys 값 0 ~ 63  /  f e d c b a
		Node(int x, int y, int z) {
			dx = x; dy = y; keys = z;
		}
	}
}
