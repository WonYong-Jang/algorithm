package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 경찰차 
 */
public class baek2618 {
	
	static int N, W, cnt;
	static int[][] dp = new int[1005][1005];
	static Point[] point1 = new Point[1005];
	static Point[] point2 = new Point[1005];
	static ArrayList<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		int dx = 0, dy = 0;
		point1[0] = new Point(1,1);
		point2[0] = new Point(N,N);
		for(int i=1; i<= W; i++) {
		    st = new StringTokenizer(br.readLine());
		    dx = Integer.parseInt(st.nextToken());
		    dy = Integer.parseInt(st.nextToken());
		    point1[i] = new Point(dx, dy);
		    point2[i] = new Point(dx, dy);
		}
		
		for(int i=0; i<= W; i++)
            for(int j=0; j<= W; j++)
                dp[i][j] = -1; // 방문 표시 
		
		bw.write(search(0,0) + "\n");
		
		for(int i=0; i<= W; i++) {
		    for(int j=0; j<= W; j++) {
		        System.out.print(dp[i][j] + " ");
		    }
		    System.out.println();
		}
		
		bw.flush();
	}
	public static int search(int dx, int dy) {
	    if(dx == W || dy == W) return 0;
	    else if(dp[dx][dy] != -1 ) return dp[dx][dy]; // -1이 아니라면 이후에 동일한 트리 모양의 방식으로 진행되기 때문 
	    else {
	        
	        int next = max(dx, dy)+1; // 한 사건을 두 차량이 사건을 맡는 경우는 없기 때문에 
	        
	        int dis1 = abs(point1[dx].dx,point1[next].dx) + abs(point1[dx].dy, point1[next].dy);
	        int ret1 = search(next, dy) + dis1; // dx가 사건을 맡은 경우 
	        
	        int dis2 = abs(point2[dy].dx,point2[next].dx) + abs(point2[dy].dy, point2[next].dy);
	        int ret2 = search(dx, next) + dis2;
	        
	        return dp[dx][dy] = min(ret1, ret2);
	    }
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int min(int a, int b) { return a > b ? b : a; }
	public static int abs(int a, int b) { return a > b ? a - b : b - a; }
	static class Point {
	    int dx, dy;
	    Point(int a, int b) {
	        dx =a; dy =b;
	    }
	}
	
}

/**
6
2
1 1
1 2
 */
