text_1 = input()
text_2 = input()

length = max(len(text_2), len(text_1))

answer = 0
lcs = [[0] * (length+1) for _ in range(length+1)]

for i in range(1, len(text_1)+1):
    for j in range(1, len(text_2)+1):
        if text_1[i-1] == text_2[j-1]:
            lcs[i][j] = lcs[i-1][j-1]+1
        else:
            lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])
print(lcs[len(text_1)][len(text_2)])