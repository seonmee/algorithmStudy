package com.algorithm.week11.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5567 {
	static int n, m, ans;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adjList = new ArrayList<>();
		// 인접 리스트
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjList.get(from).add(to);
			adjList.get(to).add(from);
		}
		// 로직
		visited = new boolean[n + 1];
		bfs();
		// 출력
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(0); // 상근이는 1번
		visited[0]=true;
		int cnt = 0;
		while (!que.isEmpty()) {
			// level 단위 처리
			int size = que.size();
			while(--size>=0) {		
				int cur = que.poll();
				for (Integer friend : adjList.get(cur)) {
					if (!visited[friend]) {
						que.add(friend);
						visited[friend] = true;
						ans++;
					}
				}
			}
			cnt++;
			if (cnt == 2)
				break;
		}

	}

}
