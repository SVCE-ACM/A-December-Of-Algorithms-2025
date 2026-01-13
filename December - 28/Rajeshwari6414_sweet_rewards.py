n = int(input())
scores = list(map(int, input().split()))

candies = [1]*n

for i in range(1, n):
    if scores[i] > scores[i-1]:
        candies[i] = candies[i-1] + 1

for i in range(n-2, -1, -1):
    if scores[i] > scores[i+1]:
        candies[i] = max(candies[i], candies[i+1] + 1)

print(sum(candies))
