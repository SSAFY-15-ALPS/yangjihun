import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수열과 쿼리 17 - G1
 * https://www.acmicpc.net/problem/14438
 */
public class Main {

	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();
		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = nextInt();
		}
		tree = new long[4 * N + 1];
		build(1, 1, N);

		int M = nextInt();
		for (int i = 0; i < M; i++) {
			int a = nextInt(), b = nextInt(), c = nextInt();

			if (a == 1) {
				update(1, 1, N, b, c);
			} else {
				sb.append(query(1, 1, N, b, c)).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	static long build(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start];

		int mid = (start + end) / 2;
		return tree[node] = Math.min(build(node * 2, start, mid),
		                             build(node * 2 + 1, mid + 1, end));
	}

	static long update(int node, int start, int end, int idx, int value) {
		if (idx < start || end < idx) return tree[node];

		if (start == end) return tree[node] = value;

		int mid = (start + end) / 2;
		return tree[node] = Math.min(update(node * 2, start, mid, idx, value),
		                             update(node * 2 + 1, mid + 1, end, idx, value));
	}

	static long query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return Long.MAX_VALUE;

		if (left <= start && end <= right) return tree[node];

		int mid = (start + end) / 2;
		return Math.min(query(node * 2, start, mid, left, right),
		                query(node * 2 + 1, mid + 1, end, left, right));
	}


	// Libraries
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;

	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static void init() throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
