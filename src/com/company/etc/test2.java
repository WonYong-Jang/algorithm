package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class test2 {
    
    static int N;
    static int[] data, temp;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        data = new int[N+1];
        temp = new int[N+1];
        for(int i=1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        divide(1, N);
        
        
        for(int i=1; i<= N; i++) {
            bw.write(data[i]+"\n");
        }
        bw.flush();
    }
    public static void divide(int s, int e) {
        
        if(s >= e) return ;
        int mid = ( s + e ) / 2;
        divide(s, mid);
        divide(mid+1, e);
        merge(s, e);
    }
    public static void merge(int s, int e) {
        
        for(int i=s; i<= e; i++) temp[i] = data[i];
        
        int mid = ( s + e ) / 2;
        int i = s, j= mid+1, k = s ;
        
        while(i <= mid && j <= e) {
            
            if(temp[i] < temp[j]) data[k++] = temp[i++];
            else data[k++] = temp[j++];
        }
        
        while(i <= mid) data[k++] = temp[i++];
        while(j <= mid) data[k++] = temp[j++];
    }
}
