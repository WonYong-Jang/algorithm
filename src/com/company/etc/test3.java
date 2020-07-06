package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test3 {
    
    static long A, B, C;  
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        
        bw.write(pow(A,B)+"\n");
        bw.flush();
    }
    public static long pow(long a, long b) {
        if(b == 0) return 1;
        else {
            
            long k = 0;
            if(b % 2 == 0) {
                k = pow(a, b/2);
                return (k * k) % C;
            }
            else {
                long temp = 0;
                k = pow(a, b/2);
                temp = ( k * k) % C;
                return (a * temp) % C;
            }
        }
    }
}
