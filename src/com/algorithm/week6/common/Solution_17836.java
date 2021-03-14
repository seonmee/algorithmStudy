package com.algorithm.week6.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 공주님을 구하라!
public class Solution_17836 {
	static int N, M, T;
	/**
	 * 3 3 10
	 * 0 1 2
	 * 0 1 1
	 * 0 0 0 
	 * */
	static int time= Integer.MAX_VALUE;
	static int[][] map, visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1 ,0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		// 1) gram을 찾고
		moveToGram(); 
		// 출력
		System.out.println(time <= T ? time : "Fail");
	}

	/**
	 * bfs로 4방탐색을 하며 공주와 그람을 찾는 함수
	 */
	private static void moveToGram() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
		visited[0][0]=1;
		boolean flag = false;
		while(!que.isEmpty()) {
			int[] m = que.poll();
			int r = m[0];
			int c = m[1];
			// 공주를 찾으면
			if(r==N-1 && c==M-1) {
				if(flag) {
					// 그람을 찾았을 경우
					time = time<=visited[r][c]-1?time:visited[r][c]-1;// 최단 거리
				}else {
					time = visited[r][c]-1;
				}
				return;
			}
			// 그람 찾기 (4방)
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isContain(nr, nc)) {
					if(visited[nr][nc]!=0)continue;
					// 이동 가능
					if (map[nr][nc]==0) {
						visited[nr][nc] = visited[r][c]+1;
						que.offer(new int[] {nr,nc});
					}
					// 그람을 찾았으면
					if (map[nr][nc] == 2) {
						visited[nr][nc] = visited[r][c]+1;
						time = visited[r][c]+(N-1 - nr) + (M-1 - nc);// 최단 거리
						flag=true;
					}
				}
			}
			if(!flag) {
				time=10001;
			}
		}	
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
