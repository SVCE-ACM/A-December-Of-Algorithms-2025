n = int(input())
skills = [int(i) for i in input().split()]

total_sum = sum(skills)
target = total_sum // 2

possible_sums = {0}

for s in skills:
    new_sums = set()
    for existing_sum in possible_sums:
        current_sum = existing_sum + s
        if current_sum <= target:
            new_sums.add(current_sum)
    possible_sums.update(new_sums)

max_reachable_sum = max(possible_sums)
min_diff = abs(total_sum - 2 * max_reachable_sum)
print(min_diff)

