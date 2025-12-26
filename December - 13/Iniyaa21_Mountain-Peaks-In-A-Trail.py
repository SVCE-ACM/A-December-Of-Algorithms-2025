n = int(input())
heights = [int(i) for i in input().split()]

peaks = []

for i in range(1, n - 1):
    if heights[i] > heights[i - 1] and heights[i] > heights[i + 1]:
        peaks.append(i)

if peaks:
    print(' '.join(map(str, peaks)))
else:
    print(-1)