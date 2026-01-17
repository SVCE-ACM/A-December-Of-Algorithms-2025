def find_mountain_peaks(heights):
    n = len(heights)
    peaks = []
    for i in range(1, n-1):
        if heights[i] > heights[i-1] and heights[i] > heights[i+1]:
            peaks.append(i)
    if peaks:
        print(" ".join(map(str, peaks)))
    else:
        print(-1)

N =int(input())
heights =list(map(int,input().split()))
find_mountain_peaks(heights)
