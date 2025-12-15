# Balanced Team Assignment
N = int(input().strip())
skills = list(map(int, input().split()))
total = sum(skills)
target = total // 2

dp = {0}
for s in skills:
    new_dp = set(dp)
    for x in dp:
        if x + s <= target:
            new_dp.add(x + s)
    dp = new_dp

best = max(dp)
print(abs(total - 2*best))
