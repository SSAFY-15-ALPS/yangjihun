import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test=1; test<=T; test++) {
			int[] a = {1,0,0};
			int N = sc.nextInt();
			for (int i=2; i<N+2;i++) {
				a[i%3] = a[(i-1)%3] + a[(i-2)%3];
			}
			System.out.println(a[N%3] +  " " + a[(N+1)%3]);
		}
	}
}