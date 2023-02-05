package _2월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/10026
 * 
 * @author Zizon_Yonni
 *
 */

public class BOJ_G5_10026_적록색약 {

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static char matrix_1[][];
	static char matrix_2[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static boolean visited_1[][];
	static boolean visited_2[][];

	static int result_1;
	static int result_2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		matrix_1 = new char[N][N];
		matrix_2 = new char[N][N];

		visited_1 = new boolean[N][N];
		visited_2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			String input2 = input.replace("R","G");
			matrix_1[i] = input.toCharArray();
			matrix_2[i] = input2.toCharArray();
			
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited_1[r][c]) {
					DFS1(new Point(r, c));
					result_1++;
				}
				if (!visited_2[r][c]) {
					DFS2(new Point(r, c));
					result_2++;
				}
			}
		}

		sb.append(result_1).append(" ").append(result_2);
		System.out.println(sb);

	}

	// 정상인
	public static void DFS1(Point point) {

		int x = point.x;
		int y = point.y;

		char color = matrix_1[x][y];
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!(nx >= 0 && ny >= 0 && nx < N && ny < N))
				continue;
			if (visited_1[nx][ny])
				continue;

			if (matrix_1[nx][ny] != color)
				continue;

			visited_1[nx][ny]=true;
			DFS1(new Point(nx, ny));

		}

	}

	public static void DFS2(Point point) {
		int x = point.x;
		int y = point.y;

		char color = matrix_2[x][y];
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!(nx >= 0 && ny >= 0 && nx < N && ny < N))
				continue;
			if (visited_2[nx][ny])
				continue;

			if (matrix_2[nx][ny] != color)
				continue;

			
			visited_2[nx][ny]=true;
			DFS2(new Point(nx, ny));

		}
	}

}
