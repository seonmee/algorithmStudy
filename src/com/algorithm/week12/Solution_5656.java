package com.algorithm.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 1. 구슬 선택 중복 순열
// 2. 가장 위에 있는 벽돌 찾기
// 3. 공격
// 4. 빈 곳 채우기
public class Solution_5656 {
	
	static class Brick {
		int r;
		int c;
		int distance;
		
		public Brick() {
		}
		
		public Brick(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		
	};
	
	static int T, N, W, H, ans = Integer.MAX_VALUE;
	static int[] marble;
	static int[][] map, temp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 구슬 갯수
			W = Integer.parseInt(st.nextToken()); // c
			H = Integer.parseInt(st.nextToken()); // r
			map = new int[H][W];
			temp = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			marble = new int[N];
			ans = Integer.MAX_VALUE;
			selectColumn(0);
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void selectColumn(int cnt) {
		if(cnt==N) {
			temp = copyMap();
			for (int i = 0; i < N; i++) {
				// 구슬 던지기
				attackTop(marble[i]);
			}
			// 벽돌 갯수 count
			ans = Math.min(countBrick(),ans);
			return;
		}
		for (int i = 0; i < W; i++) {
			marble[cnt] = i;
			selectColumn(cnt+1);
		}
	}
	private static int[][] copyMap() {
		for (int r = 0; r < H; r++) {
			temp[r] = Arrays.copyOf(map[r], W);
		}
		return temp;
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void attackTop(int stc) {
		Queue<Brick> que = new LinkedList<Brick>();
		// findTop : 가장위의 벽돌 찾기
		for (int r = 0; r < H; r++) {
			if(temp[r][stc]!=0){
				que.offer(new Brick(r, stc, temp[r][stc]));
				break;
			}
		}
		// remove Brick : 벽돌 제거하기
		Brick cur;
		int cr, cc, cd, nr, nc;
		while(!que.isEmpty()) {
			cur = que.poll();
			cr = cur.r;
			cc = cur.c;
			cd = cur.distance;
			// 4방으로 공격
			for (int d = 0; d < 4; d++) {
				for (int ct = 0; ct < cd; ct++) { // distance만큼
					nr = cr + dr[d] * ct;
					nc = cc + dc[d] * ct;
					if(!isContain(nr,nc))break; // 범위를 벗어나면 stop
					if(temp[nr][nc]==0) continue; // 벽돌이 아니면
					que.offer(new Brick(nr, nc, temp[nr][nc]));
					temp[nr][nc] = 0; // 부수기
				}
		
			}
		}
		// 빈 칸으로 이동하기
		reorganize();
	}
	
	private static int countBrick() {
		int sum = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if(temp[r][c]!=0) sum++;
			}
		}
		return sum;
	}
	private static void reorganize() {
		for (int c = 0; c < W; c++) {
			int r = H-1; // 아래부터
			while(r>0) {
				if(temp[r][c]==0) { // 빈공간이면
					int nr = r-1;
					// 떠있는 벽돌 찾기
					while(nr>0 && temp[nr][c]==0)nr--;
					temp[r][c] = temp[nr][c];
					temp[nr][c] = 0;
				}
				r--;
			}
		}
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr< H && nc>=0 && nc< W;
	}
}
