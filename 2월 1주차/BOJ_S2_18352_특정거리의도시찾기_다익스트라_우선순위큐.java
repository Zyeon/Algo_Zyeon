package _2월1주차;
import java.util.*;

import _2월1주차.BOJ_S2_18352_특정거리의도시찾기_다익스트라.Node;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/18352
 * @author Zizon_Yonni
 *
 */
public class BOJ_S2_18352_특정거리의도시찾기_다익스트라_우선순위큐 {
	public static class Node implements Comparable<Node>
	{
		int index;
		int cost;
		
		public Node(int node, int cost) {
			super();
			this.index = node;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "[node=" + index + ", cost=" + cost+"]" ;
		}

		@Override
		public int compareTo(Node n) {
			
			return this.cost - n.cost;
		}
		
		
		
		
	}
	static int N,M;	// 도시의 개수 , 도로개수 (정점, 간선)
	static int K;	// 거리정보
	static int X;	// 출발도시의 번호 
	
	static int [] dist;		// 최소거리 저장
	static boolean [] visited;		// 방문도시 체크

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N M K X

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());		// 최단거리가 K인 값을 찾아서 출력해야함
		X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Node(end,1));	// 그래프의 해당 ArrayList<Node> get해서 Node넣어주기
		}
		
		for (int i = 0; i < N+1; i++) {
			dist[i]= Integer.MAX_VALUE;
		}
		
		dist[X]=0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.offer(new Node(X,0));
		
		while(!pq.isEmpty()) 
		{
			Node curNode = pq.poll();
			
			if(dist[curNode.index]<curNode.cost)
				continue;
			
			int size = graph.get(curNode.index).size();
			
			for (int i = 0; i <size; i++) {
				Node nextNode = graph.get(curNode.index).get(i);
				
				if(dist[nextNode.index]>curNode.cost + nextNode.cost) {
					dist[nextNode.index]= curNode.cost + nextNode.cost;
					
					pq.offer(new Node(nextNode.index,dist[nextNode.index]));
				}
				
				
			}
		}
		
		//System.out.println(Arrays.toString(dist));
		
		for (int i = 1; i < N+1; i++) {
			if(dist[i]==K)
				sb.append(i).append("\n");
		}
		
		if(sb.length()==0)
			System.out.println("-1");
		else
			System.out.println(sb);
		
		
	}

}
