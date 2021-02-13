package com.algorithm.week2.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekioon_15900 {
	static int N, ans;
	static ArrayList<ArrayList<Integer>> tree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];

		// 인접 list
		tree = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			tree.get(x).add(y);
			tree.get(y).add(x);
		}
		// 로직
		dfs(1,0);
		
		// 출력
		System.out.println((ans % 2 == 0) ? "No" : "Yes");

	}

	private static void dfs(int n, int cnt) {
		visited[n] = true;
		// 1) 인접한 노드이고
		for (int next : tree.get(n)) {
			// 2) 방문 안한 노드
			if (!visited[next]) {
				dfs(next,cnt+1);
			}
		}
		if (n != 1 && tree.get(n).size() == 1) {
			ans += cnt;
		}
	}

}
