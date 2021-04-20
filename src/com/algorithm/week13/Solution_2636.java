package com.algorithm.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈
public class Solution_2636 {
	static int R, C, str, stc, cntCheese;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) cntCheese++;
			}
		}
		int time = 0;
		int cnt = 0;
		while(true) {
			time++;
			// 1. 테두리 치즈 표시
			findCheese(str,stc);
			cnt = cntCheese;
			// 2. 치즈 녹이기
			meltCheese();
			if(cntCheese==0)break;
		}
		System.out.println(time);
		System.out.println(cnt);
		
		
		
	}
	/**
	 * 치즈 녹이는 함수
	 * */
	private static void meltCheese() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]==2) {
					cntCheese--;
					map[r][c] = 0;
					str = r;
					stc = c;
				}
			}
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	/**
	 * 테두리 치즈 표시하는 함수
	 * */
	private static void findCheese(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
		boolean[][] visited =new boolean[R][C];
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!isContain(nr,nc))continue;
				if(visited[nr][nc])continue;
				if(map[nr][nc]==1) {
					map[nr][nc] = 2; // 공기와 닿는 치즈
				}
				if(map[nr][nc]==0) {
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true; // 방문
				}
			}
		}
	}
	/**
	 * 범위 체크
	 * */
	private static boolean isContain(int nr, int nc) {
		return nr>=0&&nr<R && nc>=0&&nc<C;
	}
	

}
