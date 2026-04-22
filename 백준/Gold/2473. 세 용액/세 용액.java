import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] q = new long[N];
		for (int i=0; i<N; i++) {
			q[i] = sc.nextInt();
		}
		Arrays.sort(q);
		long[] answer = new long[3];
		Arrays.fill(answer, 1000000000);
		for (int i=0; i<N; i++) {
			int start = i+1;
			int end = N-1;
			while (start < end) {
				long sum = q[i] + q[start] + q[end];
				long ansSum = answer[0] + answer[1] + answer[2];
				if (Math.abs(ansSum) > Math.abs(sum)) {
					answer[0] = q[i];
					answer[1] = q[start];
					answer[2] = q[end];
				}
				if (sum > 0) {
					end--;
				}
				else if (sum < 0) {
					start++;
				}
				else {
					break;
				}
			}
		}
		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}
}