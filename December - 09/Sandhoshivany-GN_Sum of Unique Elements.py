from collections import Counter

N = int(input())
arr = list(map(int, input().split()))

freq = Counter(arr)
unique_sum = sum(num for num, count in freq.items() if count == 1)

print(unique_sum)
