package com.algorithm.week33;
import java.io.*;
import java.util.*;
/*
 * 상근이의 여행 
 * */
public class Solution_9372 {
	static int N,M,ans;
    static boolean[] visited;
    static int[][] arr;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ans = 0;
            
            arr = new int[N+1][N+1];
            visited = new boolean[N+1];
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u][v] = 1;
                arr[v][u] = 1;
            }
            
            bfs();
            
            System.out.println(ans-1);
        }
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
	    queue.add(1);
	    visited[1] = true;
	    while(!queue.isEmpty()) {
	        ans++;
	        int cur = queue.poll();
	        for(int i=1; i<=N; i++) {
	            if(arr[cur][i]!=0 && !visited[i]) {
	                visited[i] = true;
	                queue.add(i);
	            }
	        }
	    }
	}
}

