import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static boolean isGood(String num) {
		int len = num.length();
		for (int x = 1; x<=len/2; x++) {
			boolean same = true;
			for (int i=0; i<x; i++) {
				if (num.charAt(len - 2*x + i) != num.charAt(len-x+i)) {
					same = false;
					break;
				}
			}
			if (same) return false;
		}
		return true;
	}
	static void BT(String num, int depth) {
		if (depth==N) {
			System.out.println(num);
			System.exit(0);
		}
		
		for (int x=1; x<=3;x++) {
			String subNum = num + x;
			if (isGood(subNum)) BT(subNum,depth+1);
		}
	}
    public static void main(String[] args) {
        BT("1",1);
    }
}