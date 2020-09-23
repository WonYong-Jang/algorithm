package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
    
    static final int MAX_VALUE = 100001;
    static int[] tree = new int[4*MAX_VALUE];
    static int N; 
    static int start, end;
    static ArrayList<Node> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int width = 0, height = 0;
        for(int i=0; i< N; i++) { // input
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            arr.add(new Node(width, height));
        }
        
        Collections.sort(arr, new mySort()); // sort 
        
        start = 1;
        while(N > start) start *= 2;
        end = start + N - 1;
        
        for(int i= 0; i< N; i++) {
            
            int curHeight = arr.get(i).height;
            int cnt = findMaxCnt(i, curHeight);
            
            update(i+1, curHeight);
            System.out.println(cnt);
        }
        
        for(int i=1; i<= end; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        
        bw.flush();
    }
    public static int findMaxCnt(int index, int height) { // height 보다 작은 상자 갯수 리턴 
        
        int s = start;
        int e = start + index - 1;
        int sCnt = 0, eCnt = 0;
        
        while(s <= e) {
            
            if(e % 2 == 0) {
                if(tree[e] < height) {
                    if(eCnt == 0) eCnt = 1;
                    else eCnt *= 2;
                }
            }
            
            if(s % 2 != 0) {
                if(tree[s] < height) {
                    if(sCnt == 0) sCnt = 1;
                    else sCnt *= 2;
                }
            }
            System.out.println(">> "+s + " " + e +" " + sCnt + " " + eCnt);
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        System.out.println(index +" " + height );
        return sCnt + eCnt;
    }
    public static void update(int index, int height) {
        int sdx = start + index - 1;
        
        while(sdx > 0) {
            
            tree[sdx] = Math.max(height, tree[sdx]);
            sdx /= 2;
        }
        
    }
    static class mySort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.width == b.width) return b.height - a.height; // 밑변이 같을 경우 높이 기준 내림차순  
            else return a.width - b.width; // 밑변 기준 오름차순 
        }
    }
    static class Node {
        int width, height;
        Node(int a, int b) {
            width = a; height = b;
        }
    }
}

/**
5
1 3
2 4
3 4
3 7
5 5
 
 
 */



