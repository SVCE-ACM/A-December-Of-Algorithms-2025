n = int(input())
scores = [int(i) for i in input().split()]

sweets = [1] * n

for i in range(1, n):
    if scores[i] > scores[i-1]:
        sweets[i] = sweets[i-1] + 1

for i in range(n-2, -1, -1):
    if scores[i] > scores[i+1]:
        sweets[i] = max(sweets[i], sweets[i+1] + 1)

print(sum(sweets))