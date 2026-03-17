N = int(input())
length = 3
k = 0
while length < N:
    k += 1
    length = length*2 + (k + 3)

def solve(n, length, k):
    if k == 0:
        return 'm' if n==1 else 'o'
    
    prev = (length - (k + 3)) // 2

    if n <= prev:
        return solve(n, prev, k - 1)
    elif n > prev + (k + 3):
        return solve(n - prev - (k + 3), prev, k - 1)
    return 'm' if n==prev+1 else 'o'
    

print(solve(N, length, k))