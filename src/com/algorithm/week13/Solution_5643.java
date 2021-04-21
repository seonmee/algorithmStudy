package com.algorithm.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 키 순서
public class Solution_5643 {
	static int T, N, M;
	static ArrayList<Integer>[] top, down; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 학생수
			M = Integer.parseInt(br.readLine()); // 비교횟수
			top = new ArrayList[N];
			down = new ArrayList[N];
			for (int n = 0; n < N; n++) {
				top[n] = new ArrayList<Integer>();  
				down[n] = new ArrayList<Integer>();  
			}
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				top[from].add(to); // 위에 check
				down[to].add(from); // 아래 check
			}
			int ans = 0;
			for (int n = 0; n < N; n++) {
				if(check(n))ans++;
			}
			System.out.println("#" + t + " " +ans);
		}
	}
	private static boolean check(int start) {
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (Integer next : top[cur]) {
				if(visited[next])continue;
				visited[next]=true;
				queue.offer(next);
				cnt++;
			}
		}
		queue.offer(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (Integer next : down[cur]) {
				if(visited[next])continue;
				visited[next]=true;
				queue.offer(next);
				cnt++;
			}
		}
		
		if(cnt==N-1)return true;
		else return false;
	}

}
