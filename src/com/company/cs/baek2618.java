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
	
	static final int INF = 987654321;
	static int N, W, len, ldx, ldy, cnt;
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
		point1[0] = new Point(1, 1);
		point2[0] = new Point(N, N);
		for(int i=1; i<= W; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			point1[i] = new Point(dx, dy);
			point2[i] = new Point(dx, dy);
		}
		for(int i = 0; i <= W; i++) {
		    for(int j = 0; j <= W; j++) {
		        dp[i][j] = -1;
		    }
		}
		bw.write(solve(0,0)+"\n");
		track(0,0);
		for(int i=0; i< ans.size(); i++) {
		    bw.write(ans.get(i)+"\n");
		}
		bw.flush();
	}
	public static int solve(int dx, int dy) {
	    if(dx == W || dy == W) {
	        return 0;
	    }
	    else if(dp[dx][dy] != -1) return dp[dx][dy];
	    
	    int next = max(dx, dy) + 1;
	    
	    int dis1 = abs(point1[next].dx,point1[dx].dx) + abs(point1[next].dy,point1[dx].dy);
	    int ap1 = solve(next, dy) + dis1;
	    
	    int dis2 = abs(point2[next].dx,point2[dy].dx) + abs(point2[next].dy,point2[dy].dy);
	    int ap2 = solve(dx, next) + dis2;
	    
	    return dp[dx][dy] = min(ap1, ap2);
	}
	public static void track(int dx, int dy) {
        if(dx == W || dy == W) {
            return ;
        }
        
        int next = max(dx, dy) + 1;
        
        int dis1 = abs(point1[next].dx,point1[dx].dx) + abs(point1[next].dy,point1[dx].dy);
        int ap1 = dp[next][dy] + dis1;
        
        int dis2 = abs(point2[next].dx,point2[dy].dx) + abs(point2[next].dy,point2[dy].dy);
        int ap2 = dp[dx][next] + dis2;
        
        if(ap1 > ap2) {
            ans.add(2);
            track(dx,next);
        }
        else {
            ans.add(1);
            track(next,dy);
        }
    }
	public static int min(int a, int b) { return a > b ? b :a; }
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a;
	}
	static class Point {
		int dx, dy;
		Point(int a, int b) {
			dx=a; dy=b;
		}
	}
}

/**
6
2
1 1
1 2
 */
