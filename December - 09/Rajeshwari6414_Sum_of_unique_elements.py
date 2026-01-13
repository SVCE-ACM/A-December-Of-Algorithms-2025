from collections import Counter

N = int(input())
arr = list(map(int, input().split()))

freq = Counter(arr)
result = sum(num for num in freq if freq[num] == 1)

print(result)
