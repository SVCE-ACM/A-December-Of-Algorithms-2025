# get number of checkpoints from user
N = int(input("Enter number of checkpoints: "))

# get elevations from user
heights = list(map(int, input("Enter the elevations separated by spaces: ").split()))

peaks = []

# first and last cannot be peaks
for i in range(1, N-1):
    if heights[i] > heights[i-1] and heights[i] > heights[i+1]:
        peaks.append(i)

# output
if peaks:
    print("Indices of mountain peaks:", *peaks)
else:
    print("No peaks found (-1)")
