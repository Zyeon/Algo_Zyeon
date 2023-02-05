package _2월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1260
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S2_1260_DFS와BFS_인접그래프 {

	static int N, M, V; // 정점, 간선, 탐색시작정점번호
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph.get(start).add(end);
			graph.get(end).add(start);
		}

		
		result.append(DFS(V,new boolean[N+1],new StringBuilder())).append("\n").append(BFS(V));
		
		//System.out.println(result);
		//System.out.println(DFS(V,new boolean[N+1],new StringBuilder()));
		System.out.println(result);

	}

	static String DFS(int current, boolean [] visited,StringBuilder sb) {
		
		ArrayList<Integer> adjNodeList = graph.get(current);
		int size = adjNodeList.size();
		
		Collections.sort(adjNodeList);
		
		visited[current]=true;
		sb.append(current).append(" ");
		
		for (int i = 0; i < size; i++) {
			int nextNode = adjNodeList.get(i);
			if(!visited[nextNode]) 
			{
				DFS(nextNode,visited,sb);
			}
		}
		
		
		
		return sb.toString();
	}

	static String BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();

		boolean[] visited = new boolean[N + 1];

		q.offer(start);
		visited[start] = true;
		sb.append(start).append(" ");

		while (!q.isEmpty()) {
			int node = q.poll();
			
			ArrayList<Integer> adjNode = graph.get(node);
			Collections.sort(adjNode);
			
			int size =adjNode.size();
			
			for (int i = 0; i <size; i++) {

				int nextNode = adjNode.get(i);
				if(!visited[nextNode]) 
				{
					
					sb.append(nextNode).append(" ");
					visited[nextNode]=true;
					q.offer(nextNode);
				}
			}
			

		}

		return sb.toString();
	}

}
