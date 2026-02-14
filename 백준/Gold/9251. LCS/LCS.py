A = list(input())
B = list(input())

li = [[0] * (len(B) + 1) for _ in range(len(A) + 1)]

for i in range(1, len(A) + 1):
    for j in range(1, len(B) + 1):
        if A[i-1] == B[j-1]:
            li[i][j] = li[i-1][j-1] + 1
        else:
            li[i][j] = max(li[i-1][j], li[i][j-1])
print(li[-1][-1])