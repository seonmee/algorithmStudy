package com.algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int K; // 넓이에 곱할 수
		Queue<int[]> que = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			que.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		while (que.peek()[0] != 3) {
			que.add(que.poll());
		}
		int ans = 0,r = 0;
		for (int i = 0; i < 2; i++) {
			int c = 0;
			for (int j = 0; j < 2; j++) {
				if (que.peek()[0] == 4) {
					r -= que.peek()[1];
				}
				if (que.peek()[0] == 3) {
					r += que.peek()[1];
				}
				if (que.peek()[0] == 1) {
					c += que.peek()[1];
				}
				que.poll();
			}
			ans += r * c;
		}
		System.out.println(ans * K);
	}

}
