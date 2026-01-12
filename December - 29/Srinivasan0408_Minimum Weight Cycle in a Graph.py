class Solution:
    def minimumWeightCycle(self, V, edges):
        adj = [[] for _ in range(V)]
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        INF = float('inf')
        best_cycle = INF

        for start in range(V):

            dist = [INF] * V
            parent = [-1] * V
            dist[start] = 0
            used = [False] * V

            queue = [(0, start)]

            while queue:
                min_idx = -1
                min_val = INF
                for i in range(len(queue)):
                    if queue[i][0] < min_val:
                        min_val = queue[i][0]
                        min_idx = i

                d, u = queue.pop(min_idx)

                if used[u]:
                    continue
                used[u] = True

                for v, w in adj[u]:

                    if used[v] and parent[u] != v:
                        cycle_weight = dist[u] + dist[v] + w
                        if cycle_weight < best_cycle:
                            best_cycle = cycle_weight

                    new_d = d + w
                    if new_d < dist[v]:
                        dist[v] = new_d
                        parent[v] = u
                        queue.append((new_d, v))

        return -1 if best_cycle == float('inf') else best_cycle

V = int(input("V = ").strip())
input_line = input().strip()
edges = []
while True:
    line = input().strip()
    if line == "]":  
        break
    line = line.rstrip(",") 
    nums = line.strip()[1:-1]  
    u, v, w = map(int, nums.split(","))
    edges.append([u, v, w])
sol = Solution()
print(sol.minimumWeightCycle(V, edges))