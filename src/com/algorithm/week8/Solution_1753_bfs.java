package com.algorithm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1753_bfs {
	static int[][] map;
	static int sr, sc, er, ec;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0 ,0, -1, 1};
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			map = new int[100][100];
			// 입력
			for (int r = 0; r < 100; r++) {
				String line = br.readLine();
				for (int c = 0; c < 100; c++) {
					map[r][c] = Character.digit(line.charAt(c),10);
					if (map[r][c] == 2) {
						sr = r;
						sc = c;
					}
					if (map[r][c] == 3) {
						er = r;
						ec = c;
					}
				}
			}
			//
			ans = 0;
			bfs();
			// 출력
			System.out.println("#" + t + " "+ans);

		}
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {sr,sc});
		
		while(!queue.isEmpty()) {
			int[] cor = queue.poll();
			int cr = cor[0];
			int cc = cor[1];
			if(cr== er && cc ==ec) {
				ans = 1;
				return;
			}
			// 4방탐색
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!isContain(nr,nc))continue;
				if(map[nr][nc]==1)continue;
				map[nr][nc]=1;
				queue.offer(new int[] {nr,nc});
			}
		}
		
	}

	private static boolean isContain(int nr, int nc) {
		return nr>=0&&nr<100&&nc>=0&&nc<100;
	}

}
