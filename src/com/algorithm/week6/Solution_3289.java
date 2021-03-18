package com.algorithm.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// SWEA 서로소 집합
public class Solution_3289 {
	static int T, n, m;
	static int[] P; 
	static int[] R; // rank
	static String ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken())+1;
			m = Integer.parseInt(st.nextToken());
			ans = "";
			P = new int[n];
			R = new int[n];
			for (int i = 0; i < n; i++) {
				R[i] = 1;
			}
			make();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int method = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (method == 1) {
					if (isUnion(a, b)) {
						ans += "1";
					} else {
						ans += "0";
					}
				} else if (method == 0) {
					union(a, b); // 합집합
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static boolean isUnion(int a, int b) {
		return findSet(a) == findSet(b);
	}

	private static void make() {
		// makeSet
		for (int i = 0; i < n; i++) {
			P[i] = i;
		}
	}

	// findSet
	private static int findSet(int a) {
		if (P[a] == a)
			return a;
		return P[a] = findSet(P[a]);
	}

	// unionSet
	private static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if (pa == pb)
			return;
		if (R[pa] >= R[pb]) {
			P[pb] = pa;
			R[pa] += R[pb];
		} else {
			P[pa] = pb;
			R[pb] += R[pa];
		}
		return;
	}

}
