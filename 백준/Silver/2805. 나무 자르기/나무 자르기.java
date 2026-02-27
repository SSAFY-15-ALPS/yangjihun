import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int answer = 0;
	
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		// 정의
		int N = nextInt();
		int M = nextInt();
		int[] arr = new int[N];
		int maxNum = 0;
		int minNum = 0;
		// 할당
		for (int i=0; i<N; i++) {
			arr[i] = nextInt();
			maxNum = Math.max(maxNum, arr[i]);
		}
		// solution
		long sum;
		int mid = 0;
		while (minNum < maxNum) {
			sum = 0;
			mid = (minNum + maxNum) / 2;
			for (int x : arr) {
				if (x > mid) {
					sum += x - mid;
				}
			}
			if (sum<M) {
				maxNum = mid;
			}
			else {
				minNum = mid+1;
			}
		}
		
		System.out.println(minNum-1);
	}
}