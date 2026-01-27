import java.util.*;
public class Main {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=1; i<=N; i++) {
			for (int star = 0; star<i; star++)
				System.out.print("*");
			for (int star = i; star<N; star++) {
				System.out.print(" ");System.out.print(" ");
			}
			for (int star = 0; star<i; star++)
				System.out.print("*");
			System.out.println();
		}
		for (int i=N-1; i>0; i--) {
			for (int star = i; star>0; star--)
				System.out.print("*");
			for (int star = i; star<N; star++) {
				System.out.print(" ");System.out.print(" ");
			}
			for (int star = 0; star<i; star++)
				System.out.print("*");
			System.out.println();
		}
	}
}
