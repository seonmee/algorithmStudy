package com.algorithm.week26;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
 * 수정 필요 
 * */
public class Solution_1063  {
	static int N;
	static int[] dr = {1,1,0,-1,-1,-1,0,1 };
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String king = st.nextToken();
		String stone = st.nextToken();
		N = Integer.parseInt(st.nextToken());
		String[] move = new String[N];
		for(int i = 0; i < N; i++) {
			move[i] = br.readLine();
		}
		
		int KingPosR = king.charAt(1) - '0';
		int KingPosC = king.charAt(0) - 'A';
		int StonePosR = stone.charAt(1) - '0';
		int StonePosC = stone.charAt(0) - 'A';
		
		for(int i = 0; i < N; i++) {
			String mv = move[i];
			int d = direct(mv);
			KingPosR = KingPosR + dr[d];
			KingPosC = KingPosC + dc[d];
			
			if(!isContain(KingPosR,KingPosC))continue;
			
			if(KingPosR==StonePosR && KingPosC==StonePosC) {
				StonePosR = StonePosR + dr[d];
				StonePosC = StonePosC + dc[d];
				
				if(!isContain(StonePosR,StonePosC)) {
					StonePosR = StonePosR - dr[d];
					StonePosC = StonePosC - dc[d];
					continue;
				}
			}
			
		}
		System.out.println((char)(KingPosC + 'A') + KingPosR + "\n");
		System.out.println((char)(StonePosC + 'A') + StonePosR + "\n");
	}
	private static boolean isContain(int r, int c) {
		return r < 0 && r >= 8 && c < 1 && c > 8;
	}
	
	private static int direct(String mv) {
		if(mv == "T") return 0;
		else if(mv == "RT") return 1;
		else if(mv == "R") return 2;
		else if(mv == "RB") return 3;
		else if(mv == "B") return 4;
		else if(mv == "LB") return 5;
		else if(mv == "L") return 6;
		else if(mv == "LT") return 7;
		return 0;
	}

}
