package _2월2주차;
import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/5214
 * @author Zizon_Yonni
 * 
 * 1번역에서 N번역으로 가는데 방문하는 최소 역의 수는 몇 개일까?
 *
 */
public class BOJ_G2_5214_환승 {
	

	static int N,K,M;	// 역,연결,하이퍼튜브
	static int dist[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+1+M; i++) {
			graph.add(new ArrayList<Integer>());
		}
		dist=new int[N+1+M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<K;j++) 
			{
				int node = Integer.parseInt(st.nextToken());
				graph.get(node).add(N+1+i);
				graph.get(N+1+i).add(node);
			}
			
		}
		//System.out.println(graph.toString());
		int ans =dijkstra();
		System.out.println(ans);
	}
	
	public static int dijkstra() 
	{
		dist[1]=1;
		int ans=-1;
		
		Queue<Integer> pq = new LinkedList<Integer>();
		pq.offer(1);
		
		while(!pq.isEmpty()) 
		{
			int node = pq.poll();
			
			if(node==N) 
			{
				ans=dist[node];
				break;
			}
			
			ArrayList<Integer> list = graph.get(node);
			int size = list.size();
			
			for (int i = 0; i < size; i++) {
				int next =list.get(i);
				//0이면 방문 x
				if(dist[next]==0) 
				{
					//하이퍼 뭐시기 일경우
					if(next>N)
						dist[next]=dist[node];
					else
						dist[next]=dist[node]+1;
					pq.offer(next);
				}
				
			}
			
		}
		return ans;
	}

}
