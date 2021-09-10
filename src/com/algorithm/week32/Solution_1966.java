package com.algorithm.week32;

import java.io.*;
import java.util.*;

/*
 * 프린터 큐 
 * */
public class Solution_1966 {
	static int n, m, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			LinkedList<int[]> queue = new LinkedList<>();
			count = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++)
				// 중요도 입력 
				queue.add(new int[] { j, Integer.parseInt(br.readLine()) });
			while (!queue.isEmpty()) { 
				int[] cur = queue.poll();
				boolean isAble = true;
				for (int[] q : queue)
					if (q[1] > cur[1])
						isAble = false;
				if (isAble) {
					count++;
					if (cur[0] == m)
						break;
				} else
					queue.add(cur);
			}
			System.out.println(count);
		}

	}
}
