def solution(m, n, h, w, drops):
    def check(mid):
        # map
        desert = [[0] * n for _ in range(m)]
        for drop in range(mid):
            i,j = drops[drop]
            desert[i][j] = 1
        # 구간합 구하기
        arr_sum = [[0] * (n+1) for _ in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                arr_sum[i][j] = desert[i-1][j-1] + arr_sum[i-1][j] + arr_sum[i][j-1] - arr_sum[i-1][j-1]
        # 0이 아니면 반환
        for height in range(m-h+1):
            for width in range(n-w+1):
                num = arr_sum[height + h][width + w] - arr_sum[height + h][width] - arr_sum[height][width + w] + arr_sum[height][width]
                if num==0:
                    return [height, width]
        return None

    left, right = 0, len(drops)
    answer = [0,0]
    
    while left <= right:
        mid = (left + right) // 2
        # 비가 왔을 때 빈 구역이 있는지 체크
        res = check(mid)
        # 빈 구역이 있다면 answer에 할당
        if res is not None:
            answer = res
            left = mid + 1
        else:
            right = mid - 1
            
    return answer