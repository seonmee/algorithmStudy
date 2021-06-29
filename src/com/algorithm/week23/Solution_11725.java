package com.algorithm.week23;
import java.util.*;
/*
 * 트리의 부모 찾기
 *
 * N (2 ≤ N ≤ 100,000)
 * 
 * */
public class Solution_11725 {
	static int N;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		adjList = new ArrayList[N+1];
		for(int i = 0; i <=N; i++) adjList[i] = new ArrayList<>();
		
		for(int i = 0 ; i < N-1 ; i ++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		visited = new boolean[N+1];
		parent = new int[N+1];
		dfs(1);
		
		for(int i = 2; i <= N ; i++) {
			System.out.println(parent[i]);
		}
	}
	
	private static void dfs(int cNode) {
		visited[cNode] = true;
		
		for(Integer next : adjList[cNode]) {
			if(!visited[next]) {
				parent[next] = cNode;
				dfs(next);
			}
		}
	}

}
