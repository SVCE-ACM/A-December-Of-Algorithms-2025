import sys
from collections import deque

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    weights = list(map(int, data[1:1+n]))
    q = deque(weights)
    sorted_out = []
    while q:
        min_val = min(q)
        idx = q.index(min_val)
        for _ in range(idx):
            q.append(q.popleft())
        sorted_out.append(q.popleft())
    print(" ".join(map(str, sorted_out)))

if __name__ == "__main__":
    solve()
