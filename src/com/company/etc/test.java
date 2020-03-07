package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class test {
    
    static int N, start, end;
    static Node[] data; 
    static int[] tree;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new int[N*4]; // 인덱스 트리 전체 tree size 
        data = new Node[N+1];
        start = 1;
        while(N > start) start *= 2; // 리프 노드의 시작 인덱스 구하기 
        end = start + N - 1;         // 리프 노드의 마지막 인덱스  
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            data[i] = new Node(num, i);
        }
        
        // 값에 대해 오름차순, 값이 같다면 인덱스로 내림차순 ! 
        Arrays.sort(data, 1, N+1, new mySort());
        int ans = 0;
        for(int i=1; i<= N; i++) {
            int index = data[i].index;
            int target = getMax(1, index-1);
            ans = Math.max(ans, target+1);
            update(index, target+1);
        }
        bw.write(ans+"\n");
        bw.flush();
    }
    public static int getMax(int sdx, int edx) {
        int num = 0;
        int s = sdx + start - 1;
        int e = edx + start - 1;
        
        while( s <= e) {
            if(s % 2 != 0) num = Math.max(num, tree[s]);
            if(e % 2 == 0) num = Math.max(num, tree[e]);
            
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        
        return num;
    }
    public static void update(int idx, int num) {
        int index = idx + start - 1; // 리프노드 인덱스 값
        
        while(index > 0) { // 주의 : 기존에 있던 tree[index] 값보다 클 경우만 업데이트!
            if(tree[index] < num) {
                tree[index] = num;
                index /= 2;
            }
            else break;
        }
    }
    static class mySort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.num != b.num) return a.num - b.num;
            else return b.index - a.index;
        }
    }
    static class Node {
        int num, index;
        Node(int a, int b) { 
            num = a; index = b;
        }
    }
}





