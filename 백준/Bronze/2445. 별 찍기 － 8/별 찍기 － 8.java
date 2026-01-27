import java.util.Scanner;

/*


*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *


 */


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int j = 2*(N-i); j>0 ; j--)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		
		for (int i = N; i > 0 ; i--) {  // i = 5 4 3 2 1
			for (int j = i ; j > 0 ; j--)
				System.out.print("*");
			for (int j = 0 ; j < 2*(N-i) ; j++ )
				System.out.print(" ");
			for (int j = i ; j > 0 ; j--)
				System.out.print("*");
			System.out.println();
		}
		
		
		
	}


}
