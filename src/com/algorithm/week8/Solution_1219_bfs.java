package com.algorithm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 백준 길찾기
public class Solution_1219_bfs {
	static int N, ans;
	static int[] one, two;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			N = Integer.parseInt(st.nextToken());
			one = new int[100];
			two = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (one[from] == 0) {
					one[from] = to;
				} else {
					two[from] = to;
				}
			}
			ans = 0;
			bfs();
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			int from = queue.poll();
			if(from==99) {
				ans=1;
			}
			if (one[from] != 0) {
				queue.offer(one[from]);
			}
			if (two[from] != 0) {
				queue.offer(two[from]);
			}

		}
	}

}
