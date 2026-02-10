import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	public static void main(String[] args) throws Exception {
		int N = nextInt();
		int[][] arr = new int[N][N];
		// solution
		Queue<Integer> queue = new PriorityQueue<>(
			(a,b) -> Integer.compare(a, b)
		);
		for (int i=0; i<N*N; i++) {
			queue.add(nextInt());
			if (queue.size()>N) queue.poll();
		}
		System.out.println(queue.poll());
	}
}