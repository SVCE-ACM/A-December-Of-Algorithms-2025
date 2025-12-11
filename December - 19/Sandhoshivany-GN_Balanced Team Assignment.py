def balanced_team(skills):
    n = len(skills)
    total = sum(skills)
    target = total // 2

    
    dp = [False] * (target + 1)
    dp[0] = True  

   
    for skill in skills:
        for j in range(target, skill - 1, -1):
            if dp[j - skill]:
                dp[j] = True

    
    for j in range(target, -1, -1):
        if dp[j]:
            subset_sum = j
            break

  
    return total - 2 * subset_sum



n = int(input())
skills = list(map(int, input().split()))
print(balanced_team(skills))
