package com.algorithm.week16.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// mooTube
public class Solution_15591 {
	static int N, Q, k, v;
	static ArrayList<int[]>[] adjList;
	
	static class Edge implements Comparable<Edge>{
		int end;
		int weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
		
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 동영상 수 
		Q = Integer.parseInt(st.nextToken()); // 질문 수 
		
		adjList = new ArrayList[N];
	    for (int n = 0; n < N; n++) {
			adjList[n] = new ArrayList<int[]>();
		}
		
		for (int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[start].add(new int[] {end, weight});
			adjList[end].add(new int[] {start, weight});
		}
		StringBuilder sb = new StringBuilder();
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken())-1;
			sb.append(check(k,v)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int check(int k, int v) {
		int ans = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		queue.offer(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int[] ad : adjList[cur]) {
				if(!visited[ad[0]] && ad[1]>=k) {
					visited[ad[0]] = true;
					ans ++;
					queue.offer(ad[0]);
				}
			}
		}
		return ans;
	}

}
