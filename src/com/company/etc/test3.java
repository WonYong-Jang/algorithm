package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test3 {
    
    static int N, answer;
    static int[][] map; // input
    static int[] visit; // 숫자를 사용했는지 여부 
    static int[] data; // 사용 숫자의 해당 위치에 있는 input 배열 값 저장 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int testCase = Integer.parseInt(st.nextToken());
        
        for(int k=1; k<= testCase; k++) {
            answer = 0;
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];
            visit = new int[N];
            data = new int[N];
            
            for(int i=0; i< N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j< N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            search(0);
            
            bw.write("#"+k+" "+answer+"\n");
        }
        bw.flush();
    }
    public static void search(int size) {  
     // size: 2차원 input 배열에서 숫자 위치 row
        if(size == N) {
            
            int sum = 0;
            for(int i=0; i< N; i++) {
                sum += data[i];
            }
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i=0; i< N; i++) {
            
            if(visit[i] == 1) continue;
            visit[i] = 1;
            data[size] = map[size][i];
            search(size+1);
            
            visit[i] = 0;
        }
        
        
    }
}

/**
 * 
백트래킹은 모든 조합의 수를 살펴보는 것인데 단 조건이 만족할 때 만이다.
 모든 경우의 수를 모두 찾는 것보다 ‘경우에 따라' 훨씬 빠를 수 있다. 
 왜냐하면 조건이 만족하는 경우라는 조건이 있기 때문이다.
 해를 찾아가는 도중, 지금의 경로가 해가 될 것 같지 않으면 그 경로를 더이상 가지 않고 되돌아갑니다.
 
 깊이 우선 탐색(DFS)
DFS는 가능한 모든 경로(후보)를 탐색합니다. 따라서, 불필요할 것 같은 경로를 사전에 차단하거나 하는 등의 행동이 없으므로 경우의 수를 줄이지 못합니다.
따라서 N! 가지의 경우의 수를 가진 문제는 DFS로 처리가 불가능할 것입니다.


10
3
910 442 760
987 465 940
758 184 658
 */

/**

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    

    public static String solution(long n) {
    // Write your code here
        
        String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alpa = data.split("");
        
        // A ~ Z , AA ~ AZ, ... ZA ~ ZZ 
        String[] cell = new String[702];  // column arr
        
        int idx = 0;
        for(int i=0; i< 27; i++) {
            String first = "";
            if(i > 0) {
                first = alpa[i-1];
            }
            for(int j=0; j< 26; j++) {
                if(i == 0) cell[idx++] = alpa[j];
                else cell[idx++] = first + alpa[j];
            }
        }
        
        long row = 0, col = 0;
        String answer = "";
        
        if(n % 702 == 0) { // 맨 오른쪽 열 
            row = n/702;
            answer = Long.toString(row) + "ZZ";
        }
        else {
            row = n/702 + 1;
            col = (n % 702) - 1;
            
            answer = Long.toString(row) + cell[(int)(col)];
        }
        
        return answer;
    }

}


**/