import java.util.*;

public class Main {
	static int L,C;
	static char[] answer;
	static boolean[] visited;
	static char[] words;
	static char[] mo = {'a','e','i','o','u'};
	
	static void dfs(int pointer, int depth) {
		if (depth==L) {
			int moum = 0;
			for (int i=0; i<L; i++) {
				for (int j=0; j<5; j++) {
					if (mo[j]==answer[i]) {
						moum+=1;
						break;
					}
				}
			}
			if (L-moum>=2 && moum!=0) {
				for (int c=0; c<L; c++) {
					System.out.print(answer[c]);
				}
				System.out.println();
				return;
			}
		}
		for (int i=pointer; i<C; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			answer[depth] = words[i];
			dfs(i, depth+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		words = new char[C];
		answer = new char[C];
		visited = new boolean[C];
		for (int i=0; i<C; i++) {
			words[i] = sc.next().charAt(0);
		}
		Arrays.sort(words);
		dfs(0,0);
	}
}
