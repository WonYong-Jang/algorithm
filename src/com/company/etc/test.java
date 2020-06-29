package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test {
    
    static int N;
    static Point[] p;
    static final int INF = 1 << 30;
    static ArrayList<Point> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        p = new Point[N];
        
        int dx=0, dy=0;
        for(int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            p[i] = new Point(dx,dy);
        }
        
        Arrays.sort(p, 0, N, new xSort());
        int result = solve(0, N-1);
        
        bw.write(result+"\n");
        bw.flush();
    }
    public static int solve(int s, int e) {
        int result = INF, diff = e - s +1;
        int mid = (s + e) / 2; 
                
        if(diff <= 2) return result = dis(p[s], p[e]);
        else if(diff <= 3) return result = Math.min( dis(p[s], p[mid]), Math.min (dis(p[s],p[e]), dis(p[mid], p[e]) ));
        else {
            
            int d = Math.min(solve(s,mid), solve(mid+1, e) );
            arr.clear();
            for(int i=s; i<= e; i++) {
                int target = (p[mid].dx-p[i].dx)*(p[mid].dx-p[i].dx);
                if(target < d) arr.add(p[i]); 
            }
            
            Collections.sort(arr, new ySort());
            
            result = d;
            int len = arr.size();
            for(int i=0; i< len-1; i++) {
                for(int j= i+1; j< len  && (arr.get(j).dy - arr.get(i).dy) < result ; j++) {
                    int tmp = dis( arr.get(i), arr.get(j) );
                    
                    result = Math.min(result, tmp);
                }
            }
            
            return result;
        }
    }
    public static int dis(Point a, Point b) {
        return (a.dx-b.dx)*(a.dx-b.dx) + (a.dy-b.dy)*(a.dy-b.dy);
    }
    static class ySort implements Comparator<Point> {
        public int compare(Point a, Point b) {
            return a.dy - b.dy;
        }
    }
    static class xSort implements Comparator<Point> {
        public int compare(Point a, Point b) {
            return a.dx - b.dx;
        }
    }
    static class Point {
        int dx,dy;
        Point(int a, int b) {
            dx=a; dy=b;
        }
    }
    
}





