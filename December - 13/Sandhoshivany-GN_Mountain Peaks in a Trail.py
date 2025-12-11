# Read input
N = int(input())
heights = list(map(int, input().split()))

peaks = []

# Traverse from 1 to N-2
for i in range(1, N - 1):
    if heights[i] > heights[i - 1] and heights[i] > heights[i + 1]:
        peaks.append(i)

# Output
if peaks:
    print(*peaks)
else:
    print(-1)
