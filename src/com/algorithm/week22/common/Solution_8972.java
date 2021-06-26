package com.algorithm.week22.common;
import java.util.*;
import java.io.*;
/*
 * 미친 아두이노 
 * 
 * 1. 먼저, 종수가 아두이노를 8가지 방향(수직,수평,대각선)으로 이동시키거나, 그 위치에 그대로 놔둔다.
 * 2. 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되며, 종수는 게임을 지게 된다.
 * 3. 미친 아두이노는 8가지 방향 중에서 종수의 아두이노와 가장 가까워 지는 방향으로 한 칸 이동한다. 즉, 종수의 위치를 (r1,s1), 
 *    미친 아두이노의 위치를 (r2, s2)라고 했을 때, |r1-r2| + |s1-s2|가 가장 작아지는 방향으로 이동한다.
 * 4. 미친 아두이노가 종수의 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되고, 종수는 게임을 지게 된다.
 * 5. 2개 또는 그 이상의 미친 아두이노가 같은 칸에 있는 경우에는 큰 폭발이 일어나고, 그 칸에 있는 아두이노는 모두 파괴된다.
 * 
 * */

/*
 *  
8 8
R......R
.R...RR.
..R..RR.
........
.....R..
......R.
....I...
.......R
1444
 * */
public class Solution_8972 {
	static int R,C, jongR, jongC, moveCnt=1;
	static char[][] map;
	static int[][] crazyMap;
	static int dr[] = {1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int dc[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static class crazy {
		int r;
		int c;
		int cnt;
		public crazy(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static ArrayList<crazy> cList = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		crazyMap = new int[R][C];
		for(int r = 0; r < R ; r++) {
			String line = br.readLine();
			for(int c = 0; c < C ; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c]=='I') {
					jongR = r;
					jongC = c;
				}
				if(map[r][c]=='R') {
					cList.add(new crazy(r,c,0));
				}
			}
		}
		
		char[] dir = br.readLine().toCharArray();  // 종수가 움직이는 방향 
		
		for(int i = 0; i < dir.length ; i++) {
			int d = dir[i] - '1';
			if(!move(d)) {
				System.out.println("kraj " + moveCnt);
				System.exit(0);
			}
			else 
				moveCnt++;
		}
		for(int r = 0; r < R ; r++) {
			for(int c = 0; c < C ; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		
	}
	
	private static boolean move(int dir) {
		
		// 1) 종수 아두이노 움직임 
		map[jongR][jongC] = '.'; 
		jongR += dr[dir];
		jongC += dc[dir];
		if(map[jongR][jongC]=='R') return false;
		map[jongR][jongC] = 'I'; 
		// 2) 미친 아두이노 움직임
		for(int i = 0; i < cList.size(); i++) {
			int cr = cList.get(i).r;
			int cc = cList.get(i).c;
			int cnt = cList.get(i).cnt;
			int min = Integer.MAX_VALUE;
			
			int mr = 0, mc = 0;
			// 2-1)가장 가까운 거리 확인 
			for(int d = 0; d <9; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!isContain(nr,nc)) continue;
				if(Math.abs(jongR-nr) + Math.abs(jongC-nc) < min) {
					min = Math.abs(jongR-nr) + Math.abs(jongC-nc) ;
					mr = nr;
					mc = nc;
				}
			}
			
			// 2-2) 이동    
			if(map[mr][mc]=='I') return false;           // 종수를 잡은 경우   
			if(crazyMap[cr][cc]==0)map[cr][cc] = '.';
			cList.get(i).r = mr;
			cList.get(i).c = mc;
			map[mr][mc] ='R';
			crazyMap[mr][mc]++;
		}
		
		// crazy 아두이노 파괴
		int size = cList.size();
		for(int i = 0 ;i<size; i++) {
			int r = cList.get(i).r;
			int c = cList.get(i).c;
			if(crazyMap[r][c]>=2) {
				cList.get(i).cnt++;
			}
		}
		
		for(int i = size-1; i>=0; i--) {
			
			int r = cList.get(i).r;
			int c = cList.get(i).c;
			crazyMap[r][c] = 0;
			
			if(cList.get(i).cnt==1) {
				map[cList.get(i).r][cList.get(i).c] = '.';
				cList.remove(i);
			}
		}
		return true;
	}

	private static boolean isContain(int r, int c) {
		return 0<=r && r< R && 0<=c && c< C;
	}
	
}
