class Solution {
	static int answer;
	public int dfs(int idx, int[][] cost, int[][] hint, int[] status) {
		int total = 0;
		if (idx==hint.length) {
			for (int i=0; i<cost.length; i++) {
				int usedHints = Math.min(status[i], cost.length - 1);
				total += cost[i][usedHints];
			}
			return total;
		}
		// hint 적용 x
		answer = Math.min(answer, dfs(idx+1, cost, hint, status));
		// hint 적용 o
		for (int i=1; i<hint[idx].length; i++) {
			status[hint[idx][i]-1]++;
		}

		answer = Math.min(answer, hint[idx][0] + dfs(idx+1, cost, hint, status));

		for (int i=1; i<hint[idx].length; i++) {
			status[hint[idx][i]-1]--;
		}
    	return answer;
    }
	
    public int solution(int[][] cost, int[][] hint) {
    	answer = Integer.MAX_VALUE;
        // DFS
        int[] status = new int[cost.length];
        return dfs(0, cost, hint, status);
    }
}