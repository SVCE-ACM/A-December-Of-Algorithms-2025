import sys
from collections import Counter

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if not data:
        return
    n = data[0]
    arr = data[1:1+n]
    freq = Counter(arr)
    ans = sum(v for v, c in freq.items() if c == 1)
    print(ans)

if __name__ == "__main__":
    solve()
