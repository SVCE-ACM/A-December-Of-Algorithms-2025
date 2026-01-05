import sys
from collections import deque, defaultdict

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    target = int(data[0])
    pairs = list(map(int, data[1:]))
    adj = defaultdict(list)
    nodes = set()
    it = iter(pairs)
    for u, v in zip(it, it):
        adj[u].append(v)
        adj[v].append(u)
        nodes.add(u)
        nodes.add(v)
    if target not in nodes and target not in adj:
        print(target)
        return
    seen = {target}
    q = deque([target])
    while q:
        level = []
        for _ in range(len(q)):
            u = q.popleft()
            level.append(u)
            for nb in adj[u]:
                if nb not in seen:
                    seen.add(nb)
                    q.append(nb)
        print(", ".join(map(str, level)))

if __name__ == "__main__":
    solve()
