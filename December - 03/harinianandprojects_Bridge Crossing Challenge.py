def can_reach_end(jumps):
    farthest = 0

    for index in range(len(jumps)):
        if index > farthest:
            return False

        farthest = max(farthest, index + jumps[index])

    return True


jump_array = list(map(int, input().strip("[]").split(",")))

print(str(can_reach_end(jump_array)).lower())
