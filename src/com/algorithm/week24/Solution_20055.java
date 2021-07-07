package com.algorithm.week24;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_20055 {
    public static int N;
    public static int K;
    public static int[] A;
    public static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(simulation(0));
    }

    public static int simulation(int cnt) {
        while (isDone()) {
        	// 1. 벨트 회전
            int temp = A[A.length - 1]; 
            for (int i = A.length - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = temp;
            // 2.  로봇 회전
            for (int i = robot.length - 1; i > 0; i--) {    
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false;
            // 3. 로봇 이동
            for (int i = N - 1; i > 0; i--) {  
                if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    A[i]--;
                }
            }
            // 3-1. 올라가는 위치인 경우 : 로봇 이동 
            if (A[0] > 0) {     
                robot[0] = true;
                A[0]--;
            }
            
            cnt++;
        }

        return cnt;
    }

    public static boolean isDone() {
        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}