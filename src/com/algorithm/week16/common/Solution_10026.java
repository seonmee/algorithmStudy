package com.algorithm.week16.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 적록색약 
public class Solution_10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited, visited2;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			String st = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = st.charAt(c);
			}
		}
		// logic
		int cnt = 0, cnt2 = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					findGroup(r,c, map[r][c]);
					cnt ++;
				}
				if(!visited2[r][c]) {
					findGroup2(r,c, map[r][c]);
					cnt2 ++;
				}
				
			}
			
		}
		System.out.println(cnt + " " + cnt2);

	}
	private static void findGroup2(int r, int c, char m) {
		visited2[r][c] = true;
		for (int d= 0;  d< 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isContain(nr,nc)) continue;
			if(visited2[nr][nc])continue;
			if(map[nr][nc]=='R'&&m=='B')continue;
			if(map[nr][nc]=='G'&&m=='B')continue;
			if(map[nr][nc]=='B'&&map[nr][nc]!=m)continue;
			findGroup2(nr,nc,m);
		}
	}
	private static void findGroup(int r, int c, char m) {
		visited[r][c] = true;
		for (int d= 0;  d< 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isContain(nr,nc)) continue;
			if(visited[nr][nc])continue;
			if(map[nr][nc]!=m)continue;
			findGroup(nr,nc,m);
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
