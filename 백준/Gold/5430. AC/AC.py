T = int(input())

for test in range(T):
    # 선언 및 할당
    p = input()
    n = int(input())
    if n==0:
        li = input()
        if 'D' in p:
            print('error')
        else:
            print('[]')
        continue
    li = []
    arr = list(map(int,input()[1:-1].split(",")))
    key = False
    start = 0
    end = n-1
    for i in p:
        if i=='R':
            key = not key
            continue
        if key:
            end-=1
        else:
            start+=1
    arr = arr[start:end+1]
    if (start>end+1):
        print('error')
    else:
        if (key):
            arr.reverse()
        print('[', end='')
        for i in range(len(arr)):
            if (i!=len(arr)-1):
                print(str(arr[i])+',', end='')
            else:
                print(str(arr[i]), end='')
        print(']')