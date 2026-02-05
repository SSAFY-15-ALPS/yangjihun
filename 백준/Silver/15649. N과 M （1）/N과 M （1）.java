import java.util.*;

public class Main {
	// 선언
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	
	static void BT(int depth) {
		if (depth==M) {
			for (int i=0; i<M; i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			return;
		}
		for (int i=0;i<N;i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				BT(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		// 할당
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N];
		arr = new int[M];
		BT(0);
	}
}