import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws Exception {
		while(st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}

	static String next() throws Exception {
		while(st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return "";
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}

    public static void main(String[] args) throws Exception{
        int N = nextInt();
        int M = nextInt();
        int[][] arr = new int[N][M];
        int[][][] visited = new int[N][M][2];
        for (int i=0; i<N; i++) {
        	String line = next();
        	for (int j=0; j<M; j++) {
        		Arrays.fill(visited[i][j], Integer.MAX_VALUE);
        		arr[i][j] = line.charAt(j) - '0';
        	}
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        int nx,ny;
        int[] current;
        queue.add(new int[] {0,0,0});
        visited[0][0][0] = 1;
        visited[0][0][1] = 1;
        while (!queue.isEmpty()) {
        	current = queue.poll();
        	for (int floar=0; floar<2; floar++) {
	        	for (int i=0;i<4;i++) {
	        		ny = current[0] + dy[i];
	        		nx = current[1] + dx[i];
	        		if (ny>=0 && ny<N && nx>=0 && nx<M && visited[ny][nx][floar]==Integer.MAX_VALUE && current[2]==floar) {
	        			visited[ny][nx][floar] = 0;
	        			if (arr[ny][nx]==1) {
	        				if (floar==0) {
		    					queue.add(new int[] {ny,nx,floar+1});
		    					visited[ny][nx][floar+1] = visited[current[0]][current[1]][floar]+1;
		        			}
		        		}
	        			else {
	        				queue.add(new int[] {ny,nx,floar});
	    					visited[ny][nx][floar] = visited[current[0]][current[1]][floar]+1;
	        			}
		        	}
	        	}
	        }
	    }
        if (visited[N-1][M-1][0]==Integer.MAX_VALUE && visited[N-1][M-1][1]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]));
	}
}