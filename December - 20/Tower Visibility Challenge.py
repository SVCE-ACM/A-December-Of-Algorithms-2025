N = int(input("Enter number of towers: "))
heights = list(map(int, input("Enter tower heights: ").split()))

result = [-1] * N
stack = []

for i in range(N - 1, -1, -1):
    while stack and stack[-1] <= heights[i]:
        stack.pop()

    if stack:
        result[i] = stack[-1]

    stack.append(heights[i])

print(*result)
