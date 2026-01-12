N = int(input("Enter the number of checkpoints (N): "))
heights = list(map(int, input(f"Enter {N} space-separated elevations: ").split()))
peaks = []
for i in range(1, N-1):
    if heights[i] > heights[i-1] and heights[i] > heights[i+1]:
        peaks.append(i)
if peaks:
    print("Mountain peak indices:", " ".join(map(str, peaks)))
else:
    print("No peaks found: -1")
