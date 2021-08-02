package com.algorithm.week26.common;

import java.util.*;
import java.io.*;

/*
 * 톱니바퀴
 * 
 * */

public class Solution_14891 {
	static String[] gear;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		gear = new String[4];
		// 톱니바퀴 방향 입력 : n = 0 / s = 1
		for (int i = 0; i < 4; i++) {
			gear[i] = br.readLine();
		}

		int cnt = Integer.parseInt(br.readLine());

		// cnt 번 회전
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken())-1; // 회전하는 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향
			visited = new boolean[4];
			solve(num, dir);
		}

		System.out.println(score());
	}

	private static int score() {
		int ans = 0;
		if(gear[0].charAt(0)=='1') ans+=1;
		if(gear[1].charAt(0)=='1') ans+=2;
		if(gear[2].charAt(0)=='1') ans+=4;
		if(gear[3].charAt(0)=='1') ans+=8;
		return ans;
	}

	// num 톱니바퀴가 dir 방향으로 회전하는 함수
	private static void solve(int num, int dir) {
		visited[num]=true;
		if(num<0 || num>7)return;
		// 1) 왼쪽 확인
		// 다른 경우 회전
		if (num > 0 && gear[num].charAt(6) != gear[num - 1].charAt(2))
			if(!visited[num-1]) solve(num - 1, -dir);
		// 2) 오른쪽 확인
		if (num < 3 && gear[num].charAt(2) != gear[num + 1].charAt(6))
			if(!visited[num+1])solve(num + 1, -dir);
		// 3) num 회전
		if (dir == 1){ // 시계 방
			char last = gear[num].charAt(7);
			gear[num] = last + gear[num].substring(0, 7) ;
		}
		else {
			char first = gear[num].charAt(0);
			gear[num] = gear[num].substring(1, 8) + first;
		}
	}

}
