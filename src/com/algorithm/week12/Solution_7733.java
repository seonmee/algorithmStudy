package com.algorithm.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈도둑
public class Solution_7733 {
	static int T, N; // N<=100
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 1;
			for (int i = 1; i <= 100; i++) {
				// 요정 eat
				for (int r = 0; r < N; r++) {
					for (int c = 0; c <N; c++) {
						if(map[r][c]==i)
							map[r][c] = 0;
					}
				}
				// count
				int count = 0;
				visited = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(map[r][c]!=0 && !visited[r][c]) {
							bfs(r,c);
							count++;
						}
					}
				}
				ans = Math.max(ans, count);
				
			}
			System.out.println("#" + t +" "+ans);
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		visited[r][c] = true;
		int cr, cc, nr, nc;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			cr = cur[0];
			cc = cur[1];
			for (int d = 0; d < 4; d++) {
				nr = cr + dr[d];
				nc = cc + dc[d];
				if(!isContian(nr,nc))continue;
				if(map[nr][nc]!=0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.offer(new int[] {nr,nc});
				}
			}
		}
	}
	private static boolean isContian(int nr, int nc) {
		return nr>=0 && nr <N && nc>=0 && nc <N;
	}
	
}
