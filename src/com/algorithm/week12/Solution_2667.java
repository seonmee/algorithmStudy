package com.algorithm.week12;
// 단지번호붙히기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_2667 { 
	static int N, cnt;
	static int[][] map;
	static int[] ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line =br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		int size = 0 ,cnt =2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					findHole(i,j,cnt++);
					size++;
				}
			}
		}
		ans = new int[size];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0) {
					ans[map[i][j]-2]++;
				}
			}
		}
		Arrays.sort(ans);
		System.out.println(size);
		for (Integer ans : ans) {
			System.out.println(ans);
		}
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void findHole(int r, int c, int cnt) {
		map[r][c] = cnt;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isContain(nr,nc))continue;
			if(map[nr][nc]==1) {
				findHole(nr, nc, cnt);
			}
		}
		return;
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr <N && nc>=0 && nc <N;
	}

}
