import sys

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    heights = list(map(int, data[1:1+n]))
    res = [-1]*n
    stack = []  # indices
    for i in range(n-1, -1, -1):
        while stack and heights[stack[-1]] <= heights[i]:
            stack.pop()
        res[i] = heights[stack[-1]] if stack else -1
        stack.append(i)
    print(" ".join(map(str, res)))

if __name__ == "__main__":
    solve()
