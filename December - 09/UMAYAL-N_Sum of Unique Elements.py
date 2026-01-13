n = int(input())
arr = list(map(int, input().split()))

from collections import Counter

freq = Counter(arr)
result = sum(x for x in freq if freq[x] == 1)

print(result)
