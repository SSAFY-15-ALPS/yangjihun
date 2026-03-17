import sys

input = sys.stdin.readline()

N = int(input)

l = 3
k = 0
while l < N:
    k += 1
    l = l * 2 + k + 3

while k >= 0:
    if k == 0:
        sys.stdout.write('m' if N == 1 else 'o')
        break

    p = (l - k - 3) // 2

    if N <= p:
        l = p
        k -= 1
    elif N > p + k + 3:
        N -= p + k + 3
        l = p
        k -= 1
    else:
        sys.stdout.write('m' if N == p + 1 else 'o')
        break