answer = 0
nodes = []
k = 0
def dfs(depth, infection_nodes, visited, current_type):
    # nodes와 k값 받아오기
    global nodes
    global k
    # 깊은 복사
    copy_visited = visited[:]
    copy_infection_nodes = infection_nodes[:]
    # k만큼 돌았다면 감염된 노드 파악 후 answer와 비교
    if depth==k:
        global answer
        count = 0
        for i in visited:
            if i:
                count+=1
        if count>answer:
            answer = count
        return
    
    # bfs
    queue = infection_nodes[:]

    # node와 연결된 노드를 돌면서 조건에 부합하면 감염 후 queue에 추가
    while queue:
        node = queue.pop()
        for next_node, pipe_type in nodes[node]:
            if pipe_type == current_type and not copy_visited[next_node]:
                copy_visited[next_node] = True
                copy_infection_nodes.append(next_node)
                queue.append(next_node)
    # 1(A)부터 3(C)까지 dfs
    for current in range(1,4):
        dfs(depth+1, copy_infection_nodes[:], copy_visited[:], current)

def solution(n, infection, edges, kk):
    global answer
    global nodes
    global k
    nodes = [[] for _ in range(n+1)]
    k = kk
    # node 할당
    for edge in edges:
        nodes[edge[0]].append([edge[1], edge[2]])
        nodes[edge[1]].append([edge[0], edge[2]])
    infection_nodes = [infection] # 감염된 노드 저장
    visited = [False for _ in range(n+1)]
    visited[infection] = True
    # 1(A)부터 3(C)까지 dfs 순회
    for i in range(1,4):
        dfs(0, infection_nodes,visited,i)
    
    return answer