package com.algorithm.week27;

import java.io.*;
import java.util.*;

/*
 * 드래곤 커브 
 * 
 * 0세대 드래곤 커브는 아래 그림과 같은 길이가 1인 선분
 * 
 * 
 * */
public class Solution_15685 {
	static int N, x, y, d, g;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static boolean[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			draw(x, y, getDir(d, g));
		}
		System.out.println(findRec());
	}

	private static int findRec() {
		int ans = 0;
		for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
                    ans++;
            }
        }
 
		return ans;
	}

	private static List<Integer> getDir(int d, int g) {
		List<Integer> ans = new ArrayList<>();
		ans.add(d);
		while(g-- >0) {
			for(int i = ans.size()-1; i >=0 ; i--) {
				int dir = (ans.get(i)+1)%4; // 시계방향 회전 
				ans.add(dir);
			}
		}
		return ans;
	}

	private static void draw(int r, int c, List<Integer> dirList) {
		map[r][c] = true;
		
		for(Integer dir : dirList) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			map[nr][nc] = true;
			r = nr;
			c = nc;
		}
	}

}
