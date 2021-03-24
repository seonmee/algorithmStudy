package com.algorithm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//SWEA 하나로
public class Solution_1251 {
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double w;

		public Edge(int from, int to, double w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.w, e.w);
		}

	}

	static int T, N;
	static double E;
	static int[] x, y, P, R;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			x = new int[N];
			y = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			// 로직
			edgeList = new ArrayList<>();
			P = new int[N];
			R = new int[N];
			Arrays.fill(R, 1);
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					double w = Math.sqrt(Math.pow(Math.abs(x[i] - x[j]),2)+Math.pow(Math.abs(y[i] - y[j]),2));
					edgeList.add(new Edge(i, j, w));
				}
			}
			Collections.sort(edgeList);
			make();

			double ans = 0;
			int count = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					ans += E * Math.pow(edge.w,2);
					if(++count==N-1)break;
				}
			}
			// 출력
			System.out.println("#" + t + " "+Math.round(ans));
		}
	}

	private static boolean union(int from, int to) {
		int pf = findSet(from);
		int pt = findSet(to);
		if (pf == pt)
			return false;
		if (R[pf] >= R[pt]) {
			P[pt] = pf;
			R[pf] += R[pt];
		} else {
			P[pf] = pt;
			R[pt] += R[pf];
		}
		return true;
	}

	private static int findSet(int v) {
		if (P[v] == v)
			return v;
		return P[v] = findSet(P[v]);
	}

	private static void make() {
		for (int i = 0; i < N; i++) {
			P[i] = i;
		}
	}

}
