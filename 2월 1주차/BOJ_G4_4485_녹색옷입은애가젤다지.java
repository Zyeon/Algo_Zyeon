package _2월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/4485
 * 
 * @author Zizon_Yonni
 *
 */

public class BOJ_G4_4485_녹색옷입은애가젤다지 {

	public static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}

	}

	static int N; // 동굴의 크기 , N =0 입력시 종료
	static int[][] matrix; // target [N-1][N-1]
	static boolean[][] visited;
	static int[][] dist;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int testCase =1;
	static int ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			matrix = new int[N][N];
			dist=new int[N][N];
			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					matrix[r][c] = Integer.parseInt(st.nextToken());
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
				
			ans=dijkstra();
			sb.append("Problem ").append(testCase++).append(": ").append(dist[N-1][N-1]).append("\n");
			

		}
		System.out.println(sb);
	}

	public static int dijkstra() {

		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		pq.offer(new Node(0, 0, matrix[0][0]));
		visited[0][0] = true;
		dist[0][0]=matrix[0][0];

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int x = curNode.x;
			int y = curNode.y;
			//int cost = curNode.cost;


			for (int d = 0; d < 4; d++) {

				int nx = x + dx[d];
				int ny = y + dy[d];

				
				
				if (!(nx >= 0 && ny >= 0 && nx < N && ny < N))
					continue;
				
				if(visited[nx][ny])
					continue;
				
				int newCost = dist[x][y]+matrix[nx][ny];
				
				if(dist[nx][ny]>newCost) 
				{
					dist[nx][ny]=newCost;
					pq.offer(new Node(nx,ny,newCost));
				}

			}

		}

		return -1;
	}

}
