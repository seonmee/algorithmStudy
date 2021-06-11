package com.algorithm.week20;

/*
 *  최소 스패팅 트리 
 * */
import java.util.*;
import java.io.*;
public class Solution_9372 {
	static int V, E;
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost,e.cost);
		}
		
	}
	static Edge[] edges;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());  // 정점 
		E = Integer.parseInt(st.nextToken());  //간선 
		
		edges = new Edge[E];
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from, to, cost);
		}
		
		Arrays.sort(edges);
		
		parent = new int[V];
		make();
		
		int totCost = 0;
		int edgeCnt = 0;
		
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				totCost += e.cost;
				if(++edgeCnt == V-1) break;
			}
		}
		System.out.println(totCost);
		
		
	}
	
	private static boolean union(int from, int to) {
		int aRoot = findSet(from);
		int bRoot = findSet(to);
		if(aRoot == bRoot) return false;
		if(aRoot<bRoot) {
			parent[bRoot] = aRoot;
		}else {
			parent[aRoot] = bRoot;
		}
		return true;
	}

	private static int findSet(int num) {
		if(parent[num]==num) return num;
		return parent[num] = findSet(parent[num]);
	}

	private static void make() {
		for(int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}

}
