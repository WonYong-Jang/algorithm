package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구슬 탈출 
 */
public class baek13460 {

	static int N, M, ans;
	static char[][] map = new char[12][12];
	static int[][][][] visit = new int[12][12][12][12];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {-1, 0 , 1, 0}, dyArr = {0 ,1, 0 ,-1};
	static int[] back = {2, 3, 0, 1}; // 반대 방향 지정 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int rdx=0, rdy=0, bdx =0, bdy=0;
		ans = -1;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				char temp = str.charAt(j-1);
				map[i][j] = temp;
				if(temp == 'B') { // 좌표 지정 
					bdx = i; bdy = j;
				}
				else if(temp =='R') {
					rdx = i; rdy = j;
				}
			}
		}
		
		que.add(new Node(rdx,rdy,bdx,bdy,1));
		visit[rdx][rdy][bdx][bdy] = 1;
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		boolean ansFlag = false;
		int nx = 0, ny =0, bIndex =0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.cnt > 10 || ansFlag) break; 
			
			int rdx=n.rdx, rdy=n.rdy, bdx=n.bdx, bdy=n.bdy;
			int srx=rdx, sry=rdy, sbx=bdx, sby=bdy; // 시작 위치 기록 
			
			for(int k=0; k<4; k++)
			{
				boolean rFlag = false, bFlag = false; // 각 색 공 통과했는지 여부
				rdx = n.rdx; rdy = n.rdy;
				while(true) // 빨간 공 
				{
					nx = rdx + dxArr[k];
					ny = rdy + dyArr[k];
					if(map[nx][ny] == '#') break;
					else if(map[nx][ny]=='O') { // 구멍 통과 
						rFlag = true; break;
					}
					rdx = nx; rdy = ny; // 좌표 갱신 
				}
				
				bdx = n.bdx; bdy = n.bdy;
				while(true) // 파란 공 
				{
					nx = bdx + dxArr[k];
					ny = bdy + dyArr[k];
					if(map[nx][ny] == '#') break;
					else if(map[nx][ny]=='O') { // 구멍 통과 
						bFlag = true; break;
					}
					bdx = nx; bdy = ny; // 좌표 갱신 
				}
				
				// 공들이 서로 겹쳤을 경우
				if(rdx == bdx && rdy == bdy)
				{
					if(k ==0 ) // 북쪽 방향일때 시작위치의 x 값이 큰값 뒤로 빼기 
					{
						bIndex = back[0];
						if(srx > sbx) rdx += dxArr[bIndex];
						else bdx += dxArr[bIndex];
					}
					else if(k ==1) // 동쪽 시작위치 y 작은 값 뒤로 
					{
						bIndex = back[1];
						if(sry > sby) bdy += dyArr[bIndex];
						else rdy += dyArr[bIndex];
					}
					else if(k ==2) // 남 x 작은값 뒤로 
					{
						bIndex = back[2];
						if(srx > sbx) bdx += dxArr[bIndex];
						else rdx += dxArr[bIndex];
					}
					else if(k==3) // 서 y 큰값 뒤로 
					{
						bIndex = back[3];
						if(sry > sby) rdy += dyArr[bIndex];
						else bdy += dyArr[bIndex];
					}
				}
				
				if(rFlag && !bFlag) { // 빨간색 공만 통과 한 경우 
					ans = n.cnt;
					ansFlag = true;
					break;
				}
				else if(!rFlag && !bFlag) { // 둘다 통과하지 못한경우 계속 검사 
					if(visit[rdx][rdy][bdx][bdy] == 1) continue;
					que.add(new Node(rdx,rdy,bdx,bdy, n.cnt+1));
					visit[rdx][rdy][bdx][bdy] = 1;
				}
				
			}
		}
	}
	static class Node {
		int rdx, rdy, bdx, bdy, cnt; // 빨간색, 파란색 좌표, 기울인 횟수 
		Node(int a, int b, int c, int d, int e) {
			rdx=a; rdy=b; bdx=c; bdy=d; cnt=e;
		}
	}
}
