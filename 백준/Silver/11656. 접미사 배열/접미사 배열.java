import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int size = S.length();
		String[] arr = new String[size];
		
		for (int i=0; i<size; i++) {
			arr[i] = S.substring(i,size);
		}
		
		Arrays.sort(arr);
		for (int i=0; i<size; i++) {
			System.out.println(arr[i]);
		}
	}
}