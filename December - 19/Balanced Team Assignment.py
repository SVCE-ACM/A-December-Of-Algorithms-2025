N = int(input())
skills = list(map(int, input().split()))

total_sum = sum(skills)
min_diff = float('inf')

for mask in range(1 << N):
    subset_sum = 0
    for i in range(N):
        if mask & (1 << i):
            subset_sum += skills[i]
    diff = abs(total_sum - 2 * subset_sum)
    if diff < min_diff:
        min_diff = diff

print(min_diff)
