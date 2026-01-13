N = int(input())
heights = list(map(int, input().split()))

stack = []
result = [-1] * N

for i in range(N - 1, -1, -1):
    while stack and stack[-1] <= heights[i]:
        stack.pop()
    result[i] = stack[-1] if stack else -1
    stack.append(heights[i])

print(*result)
