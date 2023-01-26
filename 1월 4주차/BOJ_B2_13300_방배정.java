package _1월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/13300
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_B2_13300_방배정 {

	static int N; // 학생 수
	static int K; // 최대 인원 수
	static int room[][] = new int[6][2];
	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			if (gender == 0)
				room[grade - 1][0]++;
			else
				room[grade - 1][1]++;
		}

		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 2; c++) {
				if (room[r][c] != 0) {
					result += room[r][c] / K;

					if (room[r][c] % K != 0) {
						result++;
					}
				}
			}
		}

		System.out.println(result);

	}

}
