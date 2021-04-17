package com.algorithm.week12.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_가장먼노드 {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) {
		int n = 6;
		int[][]edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, edge));
	}

	public static int solution(int n, int[][] edge) {
		int edgeNum = edge.length;
		adjList = new ArrayList[edgeNum];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < edgeNum; i++) {
			int from = edge[i][0]-1;
			int to = edge[i][1]-1;
			adjList[from].add(to);
			adjList[to].add(from);
		}
		visited = new boolean[n];
		return bfs();
	}
	
	private static int bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(0); // 1부터 시작
		visited[0] = true;
		int lastSize = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			lastSize = size;
			while(--size>=0) {
				int cur = que.poll();
				for (Integer next : adjList[cur]) {
					if(visited[next])continue;
					visited[next] = true;
					que.offer(next);
				}
			}
		}
		return lastSize;
	}
}
