n = int(input())
heights = [int(i) for i in input().split()]

result = [-1] * n
stack = []

for i in range(n):
    while stack and heights[i] > heights[stack[-1]]:
        index = stack.pop()
        result[index] = heights[i]
    stack.append(i)

print(*(result))

