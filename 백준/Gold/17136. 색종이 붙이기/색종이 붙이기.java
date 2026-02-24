import java.util.Scanner;

public class Main {
	static int answer =  Integer.MAX_VALUE;
	static int[][] map;
	static int[] paper;
	
	static void fill(int y, int x, int size, int val) {
		for (int i=y; i<y+size; i++) {
			for (int j=x; j<x+size;j++) {
				map[i][j] = val;
			}
		}
	}
	
	static boolean check(int y, int x, int size) {
		if (y+size>10 || x+size>10) return false;
		for (int i=y; i<y+size; i++) {
			for (int j=x; j<x+size; j++) {
				if (map[i][j]==0) return false;
			}
		}
		return true;
	}
	
	static void order(int y, int x, int count) {
		if (y==10 && x==0) {
			answer = Math.min(answer, count);
			return;
		}
		if (count>=answer) return;
		if (x==10) {
			order(y+1,0,count);
			return;
		}
		if (map[y][x]==1) {
			for (int p=5; p>=1; p--) {
				if (paper[p]>0 && check(y,x,p)) {
					fill(y,x,p,0);
					paper[p]--;
					order(y,x+1, count+1);
					fill(y,x,p,1);
					paper[p]++;
				}
			}
			return;
		}
		else {
			order(y,x+1,count);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		paper = new int[] {0,5,5,5,5,5};
		// 할당
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 탐색
		order(0,0,0);
		System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
	}
}