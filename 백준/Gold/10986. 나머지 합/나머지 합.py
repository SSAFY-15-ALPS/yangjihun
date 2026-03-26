from collections import defaultdict

answer = 0
N,M = map(int,input().split())
num_list = list(map(int,input().split()))
ps = [0 for _ in range(N+1)]
count_dict = defaultdict(int)

# 누적합 구하기
for i in range(N):
    ps[i+1] = (ps[i] + num_list[i]) % M

# 개수 세기
for i in range(N+1):
    count_dict[ps[i]]+=1

# 나머지 같은 거끼리의 조합 개수 구하기
for num in count_dict.values():
    answer += num * (num-1) // 2

print(answer)