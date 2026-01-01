N = int(input())
skills = list(map(int, input().split()))

total = sum(skills)
possible = {0}

for s in skills:
    possible |= {p + s for p in possible}

min_diff = min(abs(total - 2 * p) for p in possible)
print(min_diff)
