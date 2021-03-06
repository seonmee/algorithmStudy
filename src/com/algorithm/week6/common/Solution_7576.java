package com.algorithm.week6.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7576 {
	static int M, N, ans;
	static int[][] map;
	static Queue<int[]> ripen;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0,-1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ripen = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					ripen.offer(new int[]{i,j}); // 익은 토마토 위치
				}
			}
		}
		// 로직 
		bfs();
		out : for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					ans = -1;
					break out;
				}
				if(ans<map[i][j]) {
					ans=map[i][j]-1;
				}
			}
		}
		// 출력
		System.out.println(ans);
		
	}
	private static void bfs() {
		while(!ripen.isEmpty()) {
			// 시작 위치
			int[] to = ripen.poll();
			int sr = to[0];
			int sc = to[1];
			//ripen.poll();
			
			// 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = sr + dr[d];
				int nc = sc + dc[d];
				// 1) 이동범위 내에 있고 2) 안익은 토마토
				if(isContain(nr,nc)&&map[nr][nc]==0) {
					map[nr][nc] = map[sr][sc] +1; // 일수 증가
					ripen.offer(new int[] {nr,nc});
				}
			}
		}
		
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M ;
	}

}
