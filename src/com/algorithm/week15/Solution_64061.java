package com.algorithm.week15;

import java.util.Stack;
// 프로그래머스_크레인인형뽑기게임
public class Solution_64061 {
	static Stack<Integer> stack;

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

	static public int solution(int[][] board, int[] moves) {
		int answer = 0;
		stack = new Stack<>();

		for (int i = 0, size = moves.length; i < size; i++) {
			// 1) 가장위의 인형 찾기
			int c = moves[i] - 1;
			for (int r = 0, size2 = board.length; r < size2; r++) {
				if (board[r][c] != 0) { // 인형을 찾은 경우
					if (!stack.isEmpty()) {
						int pre = stack.peek();
						if (pre == board[r][c]) {  // 두개가 연속적으로 같은경우
							stack.pop();
							answer+=2;
						}
						else
							stack.add(board[r][c]);
					} else {
						stack.add(board[r][c]);
					}

					board[r][c] = 0; // 인형을 집음
					break; // 다음 위치로
				}
			}
		}
		return answer;
	}

}
