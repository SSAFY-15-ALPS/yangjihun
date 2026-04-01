text_1 = input()
text_2 = input()

length = max(len(text_2), len(text_1))

lcs = [[""] * (length+1) for _ in range(length+1)]

for i in range(1, len(text_1)+1):
    for j in range(1, len(text_2)+1):
        if text_1[i-1] == text_2[j-1]:
            lcs[i][j] = lcs[i-1][j-1]+text_1[i-1]
        else:
            if len(lcs[i-1][j]) > len(lcs[i][j-1]):
                lcs[i][j] = lcs[i-1][j]
            else:
                lcs[i][j] = lcs[i][j-1]
answer = lcs[len(text_1)][len(text_2)]
print(len(answer))
print(answer)