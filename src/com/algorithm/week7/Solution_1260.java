package com.algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 dfs bfs
public class Solution_1260 {
	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next; 
		}

		public Node(int vertex) {
			super();
			this.vertex = vertex;
		}
	}

	static int N, M, V;
	static boolean[] visited;
	static Node[] abjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		abjList = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			abjList[to] = new Node(from, abjList[to]);
			abjList[from] = new Node(to, abjList[from]);
		}
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		bfs();

	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(V);
		visited[V] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+ " ");
			for (Node temp = abjList[current]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex]=true;
				}
			}		
		}
	}

	private static void dfs(int current) {
		visited[current] = true;
		System.out.print(current+ " ");
		for (Node temp = abjList[current]; temp != null; temp = temp.next) {
			if(!visited[temp.vertex])
				dfs(temp.vertex);
		}
	}

}
