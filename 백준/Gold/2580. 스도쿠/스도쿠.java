import java.io.*;
import java.util.*;

public class Main
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	static List<int[]> blanks = new ArrayList<>();
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
	public static boolean correct(int y, int x, int num) {
		for (int i=0; i<9; i++) {
			if (arr[y][i]==num || arr[i][x]==num || arr[(y/3)*3 + i/3][(x/3)*3 + i%3]==num) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean solve(int i) {
		if (i == blanks.size()) return true;
		int x = blanks.get(i)[1];
		int y = blanks.get(i)[0];
		for (int num=1; num<=9;num++) {
			if (correct(y,x,num)) {
				arr[y][x] = num;
				if (solve(i+1)) return true;
				arr[y][x] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		// 선언
		arr = new int[9][9];
		// 할당
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				arr[i][j] = nextInt();
			}
		}
		// compute
		for (int i=0; i<9; i++) {
			for (int j=0;j<9;j++) {
				if (arr[i][j]==0) {
					blanks.add(new int[] {i, j});
				}
			}
		}
		solve(0);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}