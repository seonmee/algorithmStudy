package com.algorithm.week6.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 공주님을 구하라!
public class Solution_17836 {
	static int N, M, T, gr, gc;
	static boolean check; // 그람을 안찾고 공주를 구한 경우
	/**
	 * 3 3 10
	 * 0 1 2
	 * 0 1 1
	 * 0 0 0 
	 * */
	static int time= Integer.MAX_VALUE;
	static int[][] map, visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

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
				if(map[i][j]==2) {
					gr=i;
					gc=j;
				}
			}
		}
		// 로직
		// 1) gram을 찾고
		moveToGram();
		// 2) 공주를 구해(그람을 찾아 구한경우)
		if(!check) {
			time += (N-1 - gr) + (M-1 - gc);
		}
		// 출력
		System.out.println(time <= T ? time : "Fail");
	}

	/**
	 * bfs로 4방탐색을 하며 그람을 찾는 함수
	 */
	private static void moveToGram() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
		visited[0][0]=1;
		boolean flag = false; // 그람을 찾았나? 공주를 찾았나?
		while(!que.isEmpty()) {
			int r = que.peek()[0];
			int c = que.peek()[1];
			que.poll();
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
						time = visited[nr][nc]-1;// 최단 거리
						flag=true;
						return;
					}
					// 공주를 찾으면
					if(nr==N-1 &&nc==M-1) {
						visited[nr][nc] = visited[r][c]+1;
						time = visited[nr][nc]-1;// 최단 거리
						check=true;
						return;
					}
				}
			}
			
		}
		if(!flag) {
			time = 10000;
		}
		
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
