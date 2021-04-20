package com.algorithm.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1600 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 원숭이 이동
	static int[] dc = { 0, 0, -1, 1 };
	static int[] hr = { -1, -2, -2, -1, 1, 2, 2, 1 }; // 말 이동
	static int[] hc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine()); // 말 처럼 움직일 수 있는 횟수
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 길이
		H = Integer.parseInt(st.nextToken()); // 세로 길이
		map = new int[H][W];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		visited = new boolean[H][W][K+1];
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { 0, 0, 0, K });
		visited[0][0][K] = true;

		while (!que.isEmpty()) {

			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cnt = cur[2];
			int k = cur[3];
			if (cr == H - 1 && cc == W - 1)
				return cnt;
			// k가 남아있는 경우
			if (k > 0) {
				// 말처럼 이동 : k사용
				for (int d = 0; d < 8; d++) {
					int nr = cr + hr[d];
					int nc = cc + hc[d];
					if (!isContain(nr, nc))
						continue;
					if (map[nr][nc] == 1)
						continue;
					if (visited[nr][nc][k - 1])
						continue; // 현재를 기준으로 k를 한번 더 사용한 경우 방문
					visited[nr][nc][k - 1] = true;
					que.offer(new int[] { nr, nc, cnt + 1, k - 1 });

				}
			}
			
			// 원래대로 이동 : k미사용
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!isContain(nr, nc)) continue;   
				if (map[nr][nc] == 1) continue;     
				if (visited[nr][nc][k]) continue; 
				visited[nr][nc][k]=true;
				que.offer(new int[] { nr, nc, cnt + 1, k});

			}
		}
		return -1;
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}

}
