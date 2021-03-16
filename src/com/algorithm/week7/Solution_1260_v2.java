package com.algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 dfs bfs
public class Solution_1260_v2 {
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> abjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		abjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			abjList.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			abjList.get(from).add(to);
			abjList.get(to).add(from);
		}
		for (int i = 0; i < N; i++) {
			Collections.sort(abjList.get(i));
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
			for (int next : abjList.get(current)) {
				if(!visited[next]) {
					queue.offer(next);
					visited[next]=true;
				}
			}	
		}
	}

	private static void dfs(int current) {
		visited[current] = true;
		System.out.print(current+ " ");
		for (int next : abjList.get(current)) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}

}
