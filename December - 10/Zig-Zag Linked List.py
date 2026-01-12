N = int(input())
vals = list(map(int, input().split()))
mid = (N + 1) // 2
first_half = vals[:mid]
second_half = vals[mid:][::-1]  
result = []
for i in range(len(second_half)):
    result.append(first_half[i])
    result.append(second_half[i])
if len(first_half) > len(second_half):
    result.append(first_half[-1])

print(*result)
