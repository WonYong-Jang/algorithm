package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class test2 {
    
    static final long mod = 1000000007;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int testCase = Integer.parseInt(st.nextToken());
        
        for(int k = 1; k <= testCase; k++) {
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            
            Stack<Node> stack = new Stack<>();
            long answer = 0;
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<= N; i++) {
                
                long target = Long.parseLong(st.nextToken());
                
                if(stack.isEmpty()) stack.add(new Node(target, i));
                else {
                   
                    while(!stack.isEmpty()) {
                        Node cur = stack.peek();
                        
                        if(cur.num > target) {
                            answer = (answer + cur.index) % mod;
                            break;
                        }
                        else stack.pop();
                    }
                    stack.add(new Node(target, i));
                }
            }
            
            bw.write("#"+k+" "+answer+"\n");
        }
        bw.flush();
    }
    static class Node {
        int index;
        long num;
        Node(long a, int b) {
            num = a; index = b;
        }
    }
}
/**
N <= 500000
탑의 높이 100,000,000
1,000,000,007

1. 검사하려는 탑의 높이 보다 큰 높이 ( 가장 가까운 위치 ) 의 탑이 나올때까지 찾는다.  
2. 스택의 맨 앞의 데이터 ( stack.peek() ) 가 검사 하려는 탑의 높이 보다 작으면 pop() 
3. 검사 완료된 탑은 stack.add  

Stack<Node> stack;
ArrayList<Node> arr; 
class Node {
  int height, int index;
}

2
5
6 9 5 7 4
5
1 1 4 2 1




8
7
 */









