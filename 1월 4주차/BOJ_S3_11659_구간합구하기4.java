package _1월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11659
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S3_11659_구간합구하기4 {

	static int N, M; // 수의 개수, 합을 구해야 하는 횟수
	static int[] dp ;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			int input = Integer.parseInt(st.nextToken());
			dp[i] = dp[i - 1] + input; // 누적합 메모이제이션
		}
		

		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append(dp[j] - dp[i-1]).append("\n");
		}

		System.out.println(sb);

	}
}

/**
 * 메모이제이션을 이용한 누적합 문제
 */
