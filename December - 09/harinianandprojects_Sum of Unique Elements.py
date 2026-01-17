n = int(input())
arr = list(map(int, input().split()))

freq = {}

for x in arr:
    if x in freq:
        freq[x] += 1
    else:
        freq[x] = 1

total = 0
for key in freq:
    if freq[key] == 1:
        total += key
        
print(total)
