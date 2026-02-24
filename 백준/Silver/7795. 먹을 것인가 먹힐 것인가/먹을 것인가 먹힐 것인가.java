import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test=0; test<T; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			// 할당
			for (int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i=0; i<M; i++) {
				B[i] = sc.nextInt();
			}
			// Solution
			Arrays.sort(A);
			Arrays.sort(B);
			
			int startB = 0;
			int answer = 0;
			int count = 0;
			for (int i=0; i<N; i++) {
				while (startB<M && A[i]>B[startB]) {
					count++;
					startB++;
				}
				answer+=count;
			}
			System.out.println(answer);
		}
	}
}