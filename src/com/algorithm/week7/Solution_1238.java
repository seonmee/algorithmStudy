package com.algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238 {
	static int len, stv;
	static boolean[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken())/2;
			stv = Integer.parseInt(st.nextToken());
			arr = new boolean[101][101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to]=true;
			}
			// 로직
			int ans = Integer.MIN_VALUE;
			System.out.println("#"+t+" "+bfs(ans));
		}
	}
	private static int bfs(int ans) {
		Queue<Integer> que = new LinkedList<Integer>();
		int[] visited = new int[101];
		int maxCnt=0;
		que.offer(stv);
		visited[stv]=1;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 1; i < 101; i++) {
				if(arr[cur][i]&&visited[i]==0) {
					que.offer(i);
					visited[i]=visited[cur]+1;
				}
			}
			maxCnt = visited[cur];
		}
		for (int i = 0; i < 101; i++) {
			if (maxCnt!=visited[i]) continue;
			ans = ans > i ? ans: i;
		}
		return ans;
	}

}
