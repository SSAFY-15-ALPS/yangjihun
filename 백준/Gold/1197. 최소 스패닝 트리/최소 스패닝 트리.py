N,M = map(int,input().split())
li = []
parent = [i for i in range(N+1)]
depth = [0] * (N+1)

for i in range(M):
    a,b,c = map(int,input().split())
    li.append([a,b,c])

li.sort(key = lambda x : x[2])

def find(i):
    if parent[i]!=i:
        parent[i] = find(parent[i])
    return parent[i]

def union(a,b):
    root_a = find(a)
    root_b = find(b)
    if root_a == root_b:
        return False
    if depth[root_a] > depth[root_b]:
        parent[root_b] = root_a
    elif depth[root_a] < depth[root_b]:
        parent[root_a] = root_b
    else:
        parent[root_b] = root_a
        depth[root_a]+=1
    return True

cost = 0

for a,b,c in li:
    if union(a,b):
        cost+=c

print(cost)