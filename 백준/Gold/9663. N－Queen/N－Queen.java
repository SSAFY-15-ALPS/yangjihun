import java.util.*;

public class Main{
	static int answer = 0;
	static int N;
	static int[] visited;
	static int[][] arr;
	
	static void BT(int depth) {
		if (depth==N) {
			answer++;
			return;
		}
		
		for (int i=0; i<N;i++) {
			if (search(depth,i)) {
				visited[depth] = i;
				BT(depth+1);
				visited[depth] = -1;
			}
		}
	}
	
	static boolean search(int i, int j) {
		for (int y=0; y<i; y++) {
			if (visited[y]==j) return false;

			if (Math.abs(i-y) == Math.abs(j - visited[y])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new int[N];
		Arrays.fill(visited, -1);
		BT(0);
		System.out.println(answer);
	}
}