package com.algorithm.week30;

import java.util.*;
import java.io.*;

/* 
 * IF문 좀 대신 써줘 
 * */
public class Solution_19637 {
	static int N, M;

	static class level {
		String name;
		int num;

		public level(String name, int num) {
			super();
			this.name = name;
			this.num = num;
		}
	}

	static ArrayList<level> levels;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		levels = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			levels.add(new level(name, num));
		}

		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(solve(input) + "\n");
		}
		System.out.print(sb.toString());
	}

	private static String solve(int input) {
		int start = 0, end = levels.size() - 1, mid = 0;
		
		while (start <= end) {
			mid = (start + end) / 2;
			if (input > levels.get(mid).num)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return levels.get(end + 1).name;

	}

}
