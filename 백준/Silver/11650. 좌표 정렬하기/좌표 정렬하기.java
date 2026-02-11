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
		int[][] arr = new int[N][2];
		for (int i=0; i<N; i++) {
			arr[i][0] = nextInt();
			arr[i][1] = nextInt();
		}
		Arrays.sort(arr,(a,b) -> Integer.compare(a[1], b[1]));
		Arrays.sort(arr,(a,b) -> Integer.compare(a[0], b[0]));
		for (int i=0; i<N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}