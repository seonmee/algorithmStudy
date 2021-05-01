package com.algorithm.week14.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_21608 {
	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point p) {
			int dif1 = Integer.compare(p.cnt, this.cnt);
			int dif2 = Integer.compare(this.r, p.r);
			return dif1 == 0 ? (dif2 == 0? Integer.compare(this.c, p.c): dif2) : dif1;
		}
		
	}
	static int N;
	static int[] score = {0, 1, 10, 100, 1000};
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Point> adj;
	static Map<Integer,int[]> fv;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fv = new HashMap<Integer, int[]>();
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			int[] favorite = new int[4];
			for (int j = 0; j < 4; j++) {
				favorite[j] = Integer.parseInt(st.nextToken());
			}
			fv.put(student, favorite);
			if(one(student,favorite))continue; // true가 반환 되면 == 자리를 찾았으면 continue;
			two(student);
		}
		
		// 만족도 조사
		int ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int[] favorite = fv.get(map[r][c]);
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(!isContain(nr, nc))continue;
					for (int i = 0; i < 4; i++) {
						if(map[nr][nc]==favorite[i]) cnt++;
					}
				}
				ans += score[cnt];
			}
		}
		System.out.println(ans);
	}
	
	private static void two(int student) {
		if(adj.isEmpty()) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]==0)
					adj.add(new Point(r, c, 0));
				}
			}
		}
		for (int i = 0, size = adj.size(); i<size ; i++) {
			int r = adj.get(i).r;
			int c = adj.get(i).c;
			int cnt = adj.get(i).cnt;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(!isContain(nr, nc))continue;
				if(map[nr][nc]==0)cnt++;
			}
			adj.get(i).cnt = cnt;
		}
		Collections.sort(adj);
		map[adj.get(0).r][adj.get(0).c] = student;
	}

	private static boolean one(int student,int[] favorite) {
		boolean ans = false;
		int[][] temp = new int[N][N];
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]==favorite[i]) { // 좋아하는 학생의
						for (int d = 0; d < 4; d ++) { // 인접한 칸 확인
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(!isContain(nr,nc))continue;
							if(map[nr][nc]==0) {
								temp[nr][nc]++;
								max = Math.max(max, temp[nr][nc]);
							}
						}
					}
				}
			}
		}
		// 가장 많은 칸의 갯수 확인
		adj = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(temp[i][j]==max) adj.add(new Point(i, j, 0));
			}
		}
		// 1개만 존재하면
		if(adj.size()==1) {
			Point cur = adj.get(0);
			map[cur.r][cur.c] = student; // 자리 확정
			ans = true;
		}
		return ans;
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
