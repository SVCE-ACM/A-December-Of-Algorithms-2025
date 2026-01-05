import sys

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if len(data) < 3:
        return
    n, k = data[0], data[1]
    arr = data[2:2 + n]
    prefix = {0: -1}
    curr = 0
    res = (-1, -1)
    for i, val in enumerate(arr):
        curr += val
        need = curr - k
        if need in prefix:
            res = (prefix[need] + 1, i)
            break
        if curr not in prefix:
            prefix[curr] = i
    print(res[0], res[1])

if __name__ == "__main__":
    solve()
