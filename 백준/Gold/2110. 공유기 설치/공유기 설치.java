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
		int C = nextInt();
		int[] house = new int[N];
		// 할당
		for (int i=0; i<N; i++) {
			house[i] = nextInt();
		}
		Arrays.sort(house);
		// solution
		int dist;
		int cnt;
		int start = 0;
		int end = house[N-1] - house[0];
		while (start<=end) {
			cnt = 1;
			dist = (start+end)/2;
			for (int i=1, current=0; i<N; i++) {
				if (house[current]+dist<=house[i]) {
					cnt++;
					current = i;
				}
			}
			if (cnt<C) {
				end = dist-1;
			}
			else {
				start = dist+1;
			}
		}
		System.out.println(end);
	}
}