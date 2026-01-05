import sys
import math

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    try:
        n = int(data[0])
    except ValueError:
        return
    if n < 1:
        print()
        print(0)
        return
    limit = int(math.isqrt(n))
    squares = [i * i for i in range(1, limit + 1) if i * i <= n]
    if squares:
        print(" ".join(map(str, squares)))
    else:
        print()
    print(len(squares))

if __name__ == "__main__":
    solve()
