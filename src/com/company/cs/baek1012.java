package com.company.cs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 유기농 배추 
 */
public class baek1012 {

	static int[][] map; // input 
	static int[][] visited; // 방문 배열 
	static int M, N, K;
	static int[] dxArr = {0, 0 , 1, -1}, dyArr= {1, -1 , 0 , 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 지렁이 갯수 
			map = new int[N][M]; // (N, M) 바꿔서 입력 받기  
			visited= new int[N][M];
			int result =0;
			for(int i=0; i< K ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int dy = Integer.parseInt(st.nextToken()); // (N, M) 바꿔서 입력 받기
				int dx = Integer.parseInt(st.nextToken());
				map[dx][dy] = 1;
			}
			for(int i=0; i< N; i++)
			{
				for(int j=0; j<M; j++)
				{
					if(visited[i][j]== 1 || map[i][j] == 0) continue; // 이미 방문 했거나 지렁이가 없는 0인 값은 제외 
					result++; // 갯수 카운트 
					bfs(i,j);
				}
			}
			System.out.println(result);
		}
	}
	public static void bfs(int dx, int dy)
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(dx,dy));
		visited[dx][dy] = 1; // 방문 표시 
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int rDx = n.dx + dxArr[i];
				int rDy = n.dy + dyArr[i];
				if(isRange(rDx,rDy) && visited[rDx][rDy] == 0 && map[rDx][rDy] == 1) // 1인 지점 이고 방문한적이 없는 경우 
				{
					visited[rDx][rDy] = 1;
					que.add(new Node(rDx,rDy));
				}
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=0 && dy >=0 && dx < N && dy < M;
	}
	static class Node{
		int dx,dy;
		Node(int x, int y) {
			dx =x; dy=y;
		}
	}
}
