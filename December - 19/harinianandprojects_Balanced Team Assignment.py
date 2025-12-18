n = int(input())
skills = list(map(int, input().split()))
total = sum(skills)
half = total // 2
sums = {0}
for k in skills:
    sums |= {x + k for x in sums if x + k <= half}
best = max(sums)
print(abs(total - 2 * best))
