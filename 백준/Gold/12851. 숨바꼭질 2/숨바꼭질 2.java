import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<int[]> pq = new PriorityQueue<> (
			(a,b) -> Integer.compare(a[1], b[1])
		);
		Queue<int[]> q = new ArrayDeque<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[100001];
		int[] nm = new int[]{N,0};
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);
		int answer = 0;
		int min = Integer.MAX_VALUE;
		q.offer(nm);
		while (!q.isEmpty()) {
			nm = q.poll();
			if (nm[0]==K) {
				if (min>nm[1]) {
					answer = 0;
					visited[nm[0]] = nm[1];
					min = nm[1];
				}	
				if (min==nm[1]) {
					visited[nm[0]] = nm[1];
					answer++;
				}
				continue;
			}
			else {
				visited[nm[0]] = nm[1];
			}
			for (int x : new int[] {nm[0]+1,nm[0]-1,nm[0]*2}) {
				if (x>=0 && x<=100000 && visited[x]==-1)
					q.offer(new int[]{x,nm[1]+1});
			}
		}
		System.out.println(visited[K]);
		System.out.println(answer);
	}
}