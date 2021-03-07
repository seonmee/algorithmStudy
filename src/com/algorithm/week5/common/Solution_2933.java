package com.algorithm.week5.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2933 {
	static int R, C, N, mine, cnt;
	static char map[][];
	static boolean visited[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'x')
					mine++; // 미네랄 갯수
			}
		}
		N = Integer.parseInt(br.readLine());
		// 로직
		// 1) height 높이에서 공격!
		int height = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height = R-Integer.parseInt(st.nextToken());
			if (i % 2 == 0) { // 왼쪽 (수평 공격)
				for (int j = 0; j < C; j++) {
					if (map[height][j] == 'x') {
						mine--;
						map[height][j] = '.'; // 미네랄 파괴
						findCluster(height); // 2) 클러스터 찾기
						// 존재하면 위치변경
					}
				}
			} else { // 오른쪽
				for (int j = C - 1; j >= 0; j--) {
					if (map[height][j] == 'x') {
						mine--;
						map[height][j] = '.'; // 미네랄 파괴
						findCluster(height); // 2) 클러스터 찾기
						// 존재하면 위치변경
					}
				}
			}
		}
		// 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 떠있는 클러스터의 유무 확인
	 */
	private static void findCluster(int height) {
		cnt=1; // 클러스터 내 미네랄 수
		visited = new boolean[R][C];
		for (int i = height; i < R; i++) { // h~R
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x') {
					dfs(i, j);
					if(cnt!=mine) {// 떠있는 클러스터 인경우
						moveCluster(); // cluster 이동
					}
					return;
				}
			}
		}
	}
	/**
	 * 클러스터 이동 
	 * */
	private static void moveCluster() {
		for (int i = 0; i < C; i++) {
			int lastR = 0, cR = 0;
			for (int j = R-1; j >= 0; j--) {
				if(map[j][i]=='x') {
					lastR = j;
				}
				if(visited[j][i]){
					cR=j;
					break;
				}
			}
			for (int j = 0; j <= cR; j++) {
				map[j+lastR-cR][i] = map[j][i];
				map[j][i]='.';
			}
		}
	}

	/**
	 * 4방 탐색
	 * */
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		int nr = 0, nc =0;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(isIn(nr,nc) && !visited[nr][nc]&& map[nr][nc]=='x') {
				cnt++; // 미네랄 수 cnt
				dfs(nr,nc);
			}
		}
	}

	/**
	 * 범위 체크
	 */
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
