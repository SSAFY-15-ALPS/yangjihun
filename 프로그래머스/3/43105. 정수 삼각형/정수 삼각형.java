class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i=triangle.length-1; i>=1; i--) {
            for (int num=0; num<triangle[i-1].length; num++) {
                triangle[i-1][num] += Math.max(triangle[i][num], triangle[i][num+1]);
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}