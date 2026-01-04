N = int(input("Enter number of checkpoints: "))
heights = list(map(int, input("Enter elevations: ").split()))

peaks = []

for i in range(1, N - 1):
    if heights[i] > heights[i - 1] and heights[i] > heights[i + 1]:
        peaks.append(i)

if len(peaks) == 0:
    print(-1)
else:
    print(*peaks)
