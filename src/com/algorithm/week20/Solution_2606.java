package com.algorithm.week20;
import java.io.*;
import java.util.*;
/*
 * 바이러스
 * 
 * */
public class Solution_2606 {
	static int N,E;
	static boolean[][] adjMetrix;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adjMetrix = new boolean[N][N];
		E = Integer.parseInt(br.readLine());
		
		for(int e = 0; e <E; e++) {			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adjMetrix[from][to] = true;
			adjMetrix[to][from] = true;
		}
		
		System.out.println(spreadVirus());
		
	}
	
	private static int spreadVirus() {
		int ans = 0;
		Queue<Integer> virus = new LinkedList<>();
		visited = new boolean[N];
		virus.offer(0);
		visited[0] = true;
		while(!virus.isEmpty()) {
			int from = virus.poll();
			for(int to = 0; to<N; to++) {
				if(visited[to]) continue;
				if(adjMetrix[from][to]) {
					virus.offer(to);
					visited[to] = true;
					ans++;
				}
			}
			
		}
		
		return ans;
	}

}
