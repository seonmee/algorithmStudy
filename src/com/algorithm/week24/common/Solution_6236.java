package com.algorithm.week24.common;
import java.io.*;
import java.util.*;
/*
 * 용돈 관리 
 * */
public class Solution_6236 {

	static int N, M, max;
	static int[] moneys;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		moneys = new int[N];
		for(int i = 0; i < N ; i++) {
			moneys[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, moneys[i]);
		}
		
		System.out.println(solution());
        
	}
    // 이분 탐색 
	private static int solution() {
		int start = 1;
		int end = max * M;
		int mid = 0;
		int cnt = 0;
		while(start<=end) {
			
			mid = (start + end)/2;
			cnt = check(mid);
			
			if(cnt == -1) {
				start = mid + 1;
			} else if(cnt == M) {
				end = mid - 1;
			}
			else if(cnt > M) {
				start = mid + 1 ;
			}else {
				end = mid - 1 ;
			}
		}
		
		return start;
	}
	
	// money의 금액으로 출금을 몇번 해야하는지 확인 
	private static int check(int money) {
		int cnt = 1;
		int limit = money;
		for(int i = 0 ; i < N; i++) {
			int use = moneys[i];           // 사용할 돈  
			if(money -use < 0) return -1;  // 출금한 똔 < 사용할 돈 : 더 큰돈을 출금해야 함 
			
			if(limit - use < 0) {          
				limit = money - use;
				cnt++;
			}else {
				limit -= use;
			}
		}
		return cnt;
	}

}
