def minToFill(V, edges, water):
    graph=[[] for i in range(V)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)
    q=[]
    time=[-1]*V
    for i in range(V):
        if water[i]==1:
            q.append(i)
            time[i]=0
    while q:
        cur=q.pop(0)
        for nei in graph[cur]:
            if time[nei]==-1:
                time[nei]=time[cur]+1
                q.append(nei)
    if -1 in time:
        return -1
    return max(time)

V, E = [int(i) for i in input().split()]
edges = []
for i in range(E):
    edges.append([int(i) for i in input().split()])
water = [int(i) for i in input().split()]
print(minToFill(V, edges, water))