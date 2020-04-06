package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class test2 {
    
    static int N, M, K, start, end;
    static int[] tree;
    static Node[] data;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        start = 1;
        while(N > start) start *=2;
        end = start + N - 1;
        
        
        data = new Node[N+1];
        tree = new int[N*4];
        st = new StringTokenizer(br.readLine());
        int num = 0;
        for(int i=1; i<= N; i++) {
            num = Integer.parseInt(st.nextToken());
            data[i] = new Node(num, i);
        }
        Arrays.sort(data, 1, N+1, new mySort());
        
        for(int i=1; i<= N; i++) {
            
        }
        
        bw.flush();
    }
    public static void update(int idx) {
        int index = idx + start - 1;
        while(index > 0) {
            tree[index]++;
            index /= 2;
        }
    }
    static class mySort implements Comparator<Node> {
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





