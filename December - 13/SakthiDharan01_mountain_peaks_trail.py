import sys

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    heights = list(map(int, data[1:1+n]))
    peaks = [str(i) for i in range(1, n-1) if heights[i] > heights[i-1] and heights[i] > heights[i+1]]
    if peaks:
        print(" ".join(peaks))
    else:
        print(-1)

if __name__ == "__main__":
    solve()
