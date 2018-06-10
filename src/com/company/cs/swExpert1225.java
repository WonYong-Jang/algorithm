package com.company.cs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
 
public class swExpert1225 {
    public static Deque<Integer> que;
 
 
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        que = new LinkedList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        for(int k=1; k<= 10; k++)
        {
            String n = reader.readLine();
            input = reader.readLine().split(" ");
            for(int i=0; i<8; i++)
            {
                que.addLast(Integer.parseInt(input[i]));
            }
            int count =0;
            while(!que.isEmpty())
            {
                int num = que.poll();
                num -= (( count % 5 ) + 1) ;
                if(num <= 0) {
                    que.addLast(0);
                    break;
                }
                count++;
                que.addLast(num);
            }
            System.out.println("#"+k+" ");
            while(!que.isEmpty())
            {
                System.out.print(que.poll()+" ");
            }
        }
    }
}