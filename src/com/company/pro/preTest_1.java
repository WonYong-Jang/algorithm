package com.company.pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class preTest_1 {
    
    static final int INF = 1000000001;  
    static int N, M, start, end , ans;
    static int[] parent;
    static ArrayList<Node> arr = new ArrayList<>();
    static boolean flag;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for(int k=1; k<= testCase; k++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            arr.clear();
            ans = INF; flag = false;
            
            int s = 0, e = 0, cost = 0;
            for(int i=0; i< M; i++)
            {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());
                arr.add(new Node(s, e, cost));
            }
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            Collections.sort(arr, new sort());
            
            for(int i=0; i< M; i++)
            {
                check(arr.get(i).cost, i);
                if(flag) break;
            }
            bw.write("#"+k+" "+ans+"\n");
        }
        bw.flush();
    }
    public static void check(int minValue, int index)
    {
       int count = 0, ap = 0, bp = 0;
       for(int i=1; i<= N; i++) parent[i] = i;
       for(int i=index; i< M; i++)
       {
           Node n = arr.get(i);
           if(count == N-1) break;
           
            ap = find(n.s);
            bp = find(n.e);
            
            if (ap != bp) 
            {
                count++;
                union(ap, bp);
                ap = find(start);
                bp = find(end);
                if (ap == bp) 
                {
                    if (ans > n.cost - minValue) ans = n.cost - minValue;
                    return;
                }
            }
            
            if(i == M-1) flag = true;
            
       }
       
    }
    public static void union(int a, int b)
    {
        int ap = find(a);
        int bp = find(b);
        parent[ap] = bp;
    }
    public static int find(int a)
    {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    static class Node {
        int s, e, cost;
        Node(int a, int b, int c) {
            s = a; e = b; cost = c;
        }
    }
    static class sort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            // TODO Auto-generated method stub
            return a.cost - b.cost;
        } 
    }
}