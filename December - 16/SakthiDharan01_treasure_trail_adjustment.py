import sys

def solve():
    lines = sys.stdin.read().strip().splitlines()
    if not lines:
        return
    arr = [int(x) for x in lines[0].replace(',', ' ').split() if x]
    if len(lines) > 1:
        n = int(lines[1].strip())
    else:
        n = arr.pop() if arr else 0
    length = len(arr)
    if n <= 0 or n > length:
        print(" ".join(map(str, arr)))
        return
    idx = length - n
    arr.pop(idx)
    if arr:
        print(" ".join(map(str, arr)))
    else:
        print("[]")

if __name__ == "__main__":
    solve()
