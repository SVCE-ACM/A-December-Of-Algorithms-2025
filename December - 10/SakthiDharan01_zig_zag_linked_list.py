import sys

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    arr = list(map(int, data[1:1+n]))
    res = []
    l, r = 0, n - 1
    toggle = True
    while l <= r:
        if toggle:
            res.append(arr[l]); l += 1
        else:
            res.append(arr[r]); r -= 1
        toggle = not toggle
    print(" ".join(map(str, res)))

if __name__ == "__main__":
    solve()
