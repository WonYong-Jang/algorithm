package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;



public class test2 {
    
    static int N, M;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[N+1];
        st = new StringTokenizer(br.readLine());
        Deque<Node> que = new ArrayDeque<>();
        for(int i=1; i<= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            while(!que.isEmpty()) { // 조건에 만족할때 까지 뒷 부분 빼주기 
                Node n = que.peekLast();
                
                if(n.num >= num) que.pollLast(); // 현재 num 보다 크거나 같다면
                else break;                       // 최소값 가능성 없으므로 빼주기 
            }
            que.addLast(new Node(num, i));
            
            while(!que.isEmpty()) {
                
                if(i - que.peekFirst().index < M) break; // 범위 안에 들어와야함 
                else que.pollFirst();
            }
            ans[i] = que.peekFirst().num;
            
        }
        
        for(int i=1; i<= N; i++) {
            bw.write(ans[i]+" ");
        }
        
        bw.flush();
    }
    static class Node {
        int num, index;
        Node(int a, int b) { 
            num = a; index = b;
        }
    }
    
}





