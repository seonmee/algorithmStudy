package com.algorithm.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경비원
public class Solution_2564 {
	static int R, C, N, totDistance;
	static int[][] position;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 가로
		C = Integer.parseInt(st.nextToken()); // 세로
		totDistance = 2 * (R + C); // 전체 둘레
		N = Integer.parseInt(br.readLine()); // 상점 갯수
		position = new int[N + 1][2]; // 상점 위치
		int dir, dis;
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken()); // 방향
			dis = Integer.parseInt(st.nextToken()); // 거리

			switch (dir) {
			case 1:
				position[i][0] = 0;
				position[i][1] = dis;
				break;
			case 2:
				position[i][0] = C;
				position[i][1] = dis;
				break;
			case 3:
				position[i][0] = dis;
				position[i][1] = 0;
				break;
			case 4:
				position[i][0] = dis;
				position[i][1] = R;
				break;
			}

		}
		// 거리 구하기
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += move(position[i][0], position[i][1], position[N][0], position[N][1]);
		}
		
		System.out.println(ans);
	}

	static int[] dr = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dc = { 1, 0, -1, 0 };

	private static int move(int r, int c, int dongr, int dongc) {
		int d = 0;
		if (dongr == 0) { // 북
			d = 0;
		} else if (dongr == C) { // 남
			d = 2;
		} else if (dongc == 0) { // 서
			d = 3;
		} else if (dongc == R) { // 동
			d = 1;
		}
		int tot = 0;
		while (true) {
			// 상점 도착
			if ((r == dongr) && (c == dongc)) break;
			int nr = dongr + dr[d];
			int nc = dongc + dc[d];
			// 범위를 벗어나면 : 방향변경
			if (!isContain(nr, nc))
				d = (d + 1) % 4;
			// 이동
			dongr = dongr + dr[d];
			dongc = dongc + dc[d];
			tot++;
		}
		return Math.min(tot,totDistance-tot);
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr <= C && nc >= 0 && nc <= R;
	}

}
