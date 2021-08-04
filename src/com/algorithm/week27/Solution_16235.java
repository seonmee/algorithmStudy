package com.algorithm.week27;

import java.util.*;
import java.io.*;

/*
 * 나무 재테크 
 * */
public class Solution_16235 {
	static int N, M, K;
	static int[][] ground, plus;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class tree implements Comparable<tree> {
		int x;
		int y;
		int age;

		@Override
		public int compareTo(tree t) {
			return Integer.compare(this.age, t.age); // 나이가 어린 나무부터 양분
		}

		public tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

	}

	static List<tree> trees = new ArrayList<>();
	static Queue<tree> die, live;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅 크기
		M = Integer.parseInt(st.nextToken()); // 상도가 심은 나무의 수
		K = Integer.parseInt(st.nextToken()); // 년
		ground = new int[N][N];
		plus = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				plus[r][c] = Integer.parseInt(st.nextToken());
				ground[r][c] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken()); // 나무 나이
			trees.add(new tree(x, y, z));
		}

		System.out.println(solution());
	}

	private static int solution() {

		for (int i = 0; i < K; i++) {
			Collections.sort(trees);
			// 1) 봄
			die = new LinkedList<>();
			live = new LinkedList<>();

			for (int j = trees.size() - 1; j >= 0; j--) {
				tree cur = trees.get(j);
				int cr = cur.x;
				int cc = cur.y;
				int cAge = cur.age;
				if (ground[cr][cc] >= cAge) {
					ground[cr][cc] -= cAge;
					trees.get(j).age = cAge+1;
				} else {
					die.offer(new tree(cr, cc, cAge));
					trees.remove(j);
				}
			}

			// 2) 여름
			while (!die.isEmpty()) {
				tree t = die.poll();
				ground[t.x][t.y] += t.age / 2;
			}

			// 3) 가을
			int size = trees.size();
			for (int j = 0; j < size; j++) {
				tree cur = trees.get(j);
				if (cur.age % 5 == 0)
						spread(cur);
			}

			// 4) 겨울
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					ground[r][c] += plus[r][c];
				}
			}
		}

		return trees.size();
	}

	private static boolean isContian(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static void spread(tree cur) {
		int x = cur.x;
		int y = cur.y;
		for (int d = 0; d < 8; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			if (isContian(nx, ny)) trees.add(new tree(nx, ny, 1));
		}

	}

}
