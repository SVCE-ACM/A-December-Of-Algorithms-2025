 N = int(input("Enter number of employees: "))
skills = list(map(int, input("Enter skills: ").split()))
if len(skills) != N:
    print("Error: Number of skills does not match N.")
else:
    total = sum(skills)
    target = total // 2
    dp = [False] * (target + 1)
    dp[0] = True
    for skill in skills:
        for j in range(target, skill - 1, -1):
            if dp[j - skill]:
                dp[j] = True
    for i in range(target, -1, -1):
        if dp[i]:
            subset_sum = i
            break
    min_diff = total - 2 * subset_sum
    print(min_diff)
