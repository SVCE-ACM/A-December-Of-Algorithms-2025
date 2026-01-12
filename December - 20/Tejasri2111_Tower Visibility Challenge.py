N = int(input())
heights = list(map(int, input().split()))

res = [-1] * N
stack = []

for i in range(N - 1, -1, -1):
    while stack and stack[-1] <= heights[i]:
        stack.pop()
    if stack:
        res[i] = stack[-1]
    stack.append(heights[i])

print(*res)
