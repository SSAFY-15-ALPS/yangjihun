import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[D][2];
		arr[0] = new int[] {1,0};
		arr[1] = new int[] {0,1};
		for (int i=2; i<D; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-2][0];
			arr[i][1] = arr[i-1][1] + arr[i-2][1];
		}
		loopOut:
		for (int i=1; i<=K/arr[D-1][0]; i++) {
			for (int j=1; j<=K/arr[D-1][1]; j++) {
				if (i*arr[D-1][0] + j*arr[D-1][1] == K) {
					System.out.println(i);
					System.out.println(j);
					break loopOut;
				}
			}
		}
	}
}
