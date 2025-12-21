n = int(input())
heights = [int(i) for i in input().split()]
res = [-1] * n
stack = []
for i in range(n - 1, -1, -1):
    while stack and stack[-1] <= heights[i]:
        stack.pop()
    if stack:
        res[i] = stack[-1]
    stack.append(heights[i])
print(*res)