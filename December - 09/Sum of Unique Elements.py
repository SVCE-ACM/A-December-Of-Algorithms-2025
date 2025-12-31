N = int(input())
arr = list(map(int, input().split()))

freq = {}
for num in arr:
    freq[num] = freq.get(num, 0) + 1

unique_sum = sum(num for num, count in freq.items() if count == 1)

print(unique_sum)
