package com.algorithm.week30;

/*
 * 유미 
 * */
import java.util.*;
import java.io.*;

public class Solution_17296 {
	static class point {
		int x;
		int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	};

	static ArrayList<point> p;
	static double[][] dist;
	static boolean[] visit;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		p = new ArrayList<point>();
		dist = new double[4][4];
		visit = new boolean[4];
		
		for (int i = 0; i < 4; i++) {
			int x, y;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			p.add(new point(x, y));
		}

		for (int i = 0; i < 4; i++) {
			int x = p.get(i).x;
			int y = p.get(i).y;

			for (int j = i + 1; j < 4; j++) {
				int tx = p.get(j).x;
				int ty = p.get(j).y;
				double d = Math.sqrt((x - tx) * (x - tx) + (y - ty) * (y - ty));
				dist[i][j] = dist[j][i] = d;
			}
		}

		dfs(0, 0.0, 0);

		System.out.println(ans);
	}

	private static void dfs(int idx, double sum, int cnt) {
		if (cnt == 4) {
			ans = Math.min(ans, (int) sum);
			return;
		}
		if (visit[idx])
			return;
		visit[idx] = true;
		for (int i = 0; i < 4; i++) {
			dfs(i, sum + dist[idx][i], cnt + 1);
		}
		visit[idx] = false;

		return;
	}

}
