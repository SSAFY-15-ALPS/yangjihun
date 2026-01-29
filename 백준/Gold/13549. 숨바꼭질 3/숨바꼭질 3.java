import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<int[]> q = new ArrayDeque<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] nm = new int[]{N,0};
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);
		int answer = Integer.MAX_VALUE;
		q.offer(nm);
		
		while (!q.isEmpty()) {
			nm = q.poll();
			if (nm[0]==K) {
				answer = Math.min(answer, nm[1]);
			}
			visited[nm[0]] = nm[1];
			for (int x : new int[] {nm[0]+1,nm[0]-1}) {
				if (x>=0 && x<=100000 && visited[x]==-1)
					q.offer(new int[]{x,nm[1]+1});
			}
			if (nm[0]*2<=100000 && visited[nm[0]*2]==-1) {
				q.offer(new int[]{nm[0]*2,nm[1]});
			}
		}
		System.out.println(answer);
	}
}