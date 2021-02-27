package com.algorithm.week4.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 백준_인구이동
public class Solution_16234 {
	static int N, L, R;
	static int[][] pops, visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int popNum, uniNum = 0; // 인구 수, 연합 수

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		pops = new int[N][N];

		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pops[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		int ans = 0;
		
		while (true) {
			visited = new int[N][N];
			
			if (movePopulation())
				ans++; // 인구이동이 있으면 cnt++
			else
				break; // 없으면
		}
		// 출력
		System.out.println(ans);
	}

	/**
	 * 연합 국가를 찾은 후, 인구를 이동하는 함수 
	 */
	private static boolean movePopulation() {
		int cnt = 0; // 연합 번호
		int area = 0;
		Map<Integer, Integer> map = new HashMap<>(); // key : 연합 value : 연합의 이동후 인구수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문하지 않은 나라면
				if (visited[i][j] == 0) {
					// 연합 탐색 : 연합의 총 인구수, 연합국가 갯수를 구하는 함수
					popNum=0;
					uniNum=0;
					checkUnion(i, j, pops[i][j], ++area);
					// 탐색 결과 연합국가가 있으면
					if (pops[i][j] != popNum) {
			            // 연합의 이동후 인구수(연합 인구수/연합 국가수) 저장
						map.put(area, popNum / uniNum);  
						// 연합 번호 증가 
						cnt++;
					}
				}
			}
		}
		if (cnt == 0) return false; // 연합 국가가 없으면 이동할 필요x

		// 인구 이동
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 해당하는 연합 번호면
				if (map.containsKey(visited[i][j])) {
					pops[i][j] = map.get(visited[i][j]);
				}
			}
		}

		return true;
	}

	/**
	 * 연합 찾기 : 4방 탐색
	 */
	private static void checkUnion(int r, int c, int pop, int cnt) {
		visited[r][c] = cnt;
		popNum += pop;
		uniNum += 1;
		int nr = 0, nc = 0;
		for (int d = 0; d < dc.length; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			// 1) 범위 안의 국가 2) 방문 안한 국가 3) 연합 국가
			if (isIn(nr, nc) && visited[nr][nc] == 0 && isUnion(pops[r][c], pops[nr][nc])) {
				// 인구 수 ++ 연합수 ++
				checkUnion(nr, nc, pops[nr][nc], cnt);
			}
		}

	}

	/**
	 * 연합인지 확인하는 함수
	 */
	private static boolean isUnion(int c1, int c2) {
		return Math.abs(c1 - c2) >= L && Math.abs(c1 - c2) <= R;
	}

	/**
	 * 범위에 속하는지 확인하는 함수
	 */
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
