package com.algorithm.week1;

import java.util.Scanner;

public class Baekjoon_2564 {

	private static int r, c, s, load;
	private static int[][] store;
	private static int[] dr = { 0, -1, 0, 1 };
	private static int[] dc = { -1, 0, 1, 0 }; // 좌 상 우 하

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		r = scn.nextInt();
		c = scn.nextInt();
		s = scn.nextInt();
		load = (r + c) * 2;
		store = new int[s + 1][2];
		int dir, num;
		for (int i = 0; i <= s; i++) {
			dir = scn.nextInt();
			num = scn.nextInt();
			switch (dir) {
			case 1:
				store[i][0] = 0;
				store[i][1] = num;
				break;
			case 2:
				store[i][0] = c;
				store[i][1] = num;
				break;
			case 3:
				store[i][0] = num;
				store[i][1] = 0;
				break;
			case 4:
				store[i][0] = num;
				store[i][1] = r;
				break;
			default:
				break;
			}
		}
		int tot = 0;
		for (int i = 0; i < s; i++) {
			tot = tot + go(store[i][0], store[i][1], store[s][0], store[s][1]);
		}
		System.out.println(tot);
	}

	private static int go(int str, int stc, int dgr, int dgc) {
		int d = 0;
		if (dgr == c) {
			d = 0;
		} else if (dgc == 0) {
			d = 1;
		} else if (dgr == 0) {
			d = 2;
		} else if (dgc == r) {
			d = 3;
		}
		int tot = 0;
		while (true) {
			// str stc를 만나면 return
			if ((dgr == str) && (dgc == stc)) {
				break;
			}
			int nDgr = dgr + dr[d];
			int nDgc = dgc + dc[d];
			// 범위를 벗어나면 방향 바꾸기
			if (nDgr < 0 || nDgr > c || nDgc < 0 || nDgc > r) {
				d = (d + 1) % 4;
			}
			// 이동
			dgr = dgr + dr[d];
			dgc = dgc + dc[d];
			tot++;
		}
		return Math.min(tot, (r+c)*2-tot);
	}

}
