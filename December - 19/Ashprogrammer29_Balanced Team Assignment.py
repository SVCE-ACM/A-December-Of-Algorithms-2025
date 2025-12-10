def balanced_teams(skills):
    total = sum(skills)
    target = total // 2
    dp = {0}

    for skill in skills:
        new_dp = set()
        for s in dp:
            if s + skill <= target:
                new_dp.add(s + skill)
        dp |= new_dp

    best = max(dp)
    return total - 2 * best


N = int(input())
skills = list(map(int, input().split()))

print(balanced_teams(skills))
