package com.company.programmers;

public class pro1829 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;

class Solution {
  public static int[][] visit;
  public static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
  public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      
      visit = new int[m][n];
      
      for(int i = 0; i < m; i++)
      {
          for(int j = 0; j < n; j++)
          {
              if(visit[i][j] == 1 || picture[i][j] == 0) continue;
              numberOfArea++;
              maxSizeOfOneArea = Math.max(maxSizeOfOneArea, 
                                          solve(i, j, m, n, picture));
          }
      }
      System.out.println(numberOfArea+" "+ maxSizeOfOneArea);
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
  public static int solve(int dx, int dy, int m, int n, int[][] picture)
  {
      Queue<Node> que = new LinkedList<>();
      int target = picture[dx][dy];
      visit[dx][dy] = 1;
      int cnt = 1;
      que.add(new Node(dx,dy));
      while(!que.isEmpty())
      {
          Node cur = que.poll();
          
          for(int i = 0; i < 4; i++)
          {
              int rdx = dxArr[i] + cur.dx;
              int rdy = dyArr[i] + cur.dy;
              if(!isRange(rdx, rdy, m, n) || visit[rdx][rdy] == 1) continue;
              if(picture[rdx][rdy] == target)
              {
                  cnt++;
                  visit[rdx][rdy] = 1;
                  que.add(new Node(rdx,rdy));
              }
          }
      }
      return cnt;
  }
  public static boolean isRange(int dx, int dy, int m, int n)
  {
      return dx >= 0 && dy >=0 && dx < m && dy < n;
  }
  static class Node {
      int dx, dy;
      Node(int a, int b) {
          dx = a; dy = b;
      }
  }
} 
 */
