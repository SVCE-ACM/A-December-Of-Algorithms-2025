n = int(input())
arr = list(map(int, input().split()))

freq = {}
missing = -1
duplicate = -1

for x in arr:
    if x in freq:
        freq[x] += 1
    else:
        freq[x] = 1

for num in range(1, n+1):
    if num not in freq:
        missing = num
    elif freq[num] == 2:
        duplicate = num

print("Missing Number:", missing)
print("Duplicate Number:", duplicate)