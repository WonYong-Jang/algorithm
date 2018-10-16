package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 두 동전 
 */
public class baek16197 {

	static int N, M, ans;
	static int sdx, sdy, edx, edy;
	static char[][] map = new char[25][25];
	static int[][][][] visit = new int[25][25][25][25];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int chk = 0;
		ans = -1;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				char temp = str.charAt(j-1);
				map[i][j] = temp;
				if(temp == 'o' && chk ==0) {
					chk++;
					sdx = i; sdy = j;
				}
				else if(temp == 'o' && chk ==1){
					edx = i; edy = j;
				}
			}
		}
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		que.add(new Node(sdx,sdy,edx,edy,0));
		visit[sdx][sdy][edx][edy] = 1;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.cnt+1 > 10) break;
			
			boolean sflag = false, eflag = false; // 보드에 떨어졌는지 확인 
			int nsx =0, nsy =0, nex =0, ney = 0;
			for(int i=0; i<4; i++)
			{
				sflag = false; eflag = false;
				nsx = n.sdx + dxArr[i];
				nsy = n.sdy + dyArr[i];
				nex = n.edx + dxArr[i];
				ney = n.edy + dyArr[i];
				
				if(!isRange(nsx,nsy)) sflag = true;
				else if(isRange(nsx,nsy) && map[nsx][nsy] =='#')
				{
					nsx -= dxArr[i];
					nsy -= dyArr[i];
				}
				if(!isRange(nex,ney)) eflag = true;
				else if(isRange(nex,ney) && map[nex][ney] =='#') 
				{
					nex -= dxArr[i];
					ney -= dyArr[i];
				}
				
				if(sflag || eflag)
				{
					
					if((sflag && !eflag) || (!sflag && eflag)) 
					{
						
						ans = n.cnt+1;
						return;
					}
					else continue;
				}
				if(visit[nsx][nsy][nex][ney] == 1) continue;
				else if(map[nsx][nsy] != '#' && map[nex][ney] != '#')
				{
					visit[nsx][nsy][nex][ney] = 1;
					que.add(new Node(nsx, nsy, nex, ney, n.cnt+1));
					
				}
				
			}
			
			
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy >=1 && dx<= N && dy <= M;
	}
	static class Node {
		int sdx, sdy, edx, edy, cnt;
		Node(int a, int b, int c, int d, int e) {
			sdx=a; sdy=b; edx=c; edy=d; cnt=e;
		}
	}
}
