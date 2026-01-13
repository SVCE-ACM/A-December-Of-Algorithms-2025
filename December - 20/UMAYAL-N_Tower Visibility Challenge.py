# Tower Visibility Challenge
N = int(input().strip())
heights = list(map(int, input().split()))
stack = []
ans = [-1] * N

for i in range(N-1, -1, -1):
    while stack and stack[-1] <= heights[i]:
        stack.pop()
    if stack:
        ans[i] = stack[-1]
    stack.append(heights[i])

print(*ans)
