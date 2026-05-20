import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int len = routes.length;
        // 첫 번째 열을 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        // 종료 지점
        int end = 30001;
        // routes를 반복문을 돌며 정답 구하기
        for (int i=0; i<len; i++) {
            // 만약 end가 도로 시작 지점보다 크다면 answer+1 & end = 도로 종료 지점
        	if (end < routes[i][0]) {
        		answer++;
        		end = routes[i][1];
        	}
            // 아니라면, end를 최솟값으로 유지
        	else {
        		end = Math.min(end, routes[i][1]);
        	}
        }
        return answer;
    }
}