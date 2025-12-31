def can_reach_last_stone(stones):
    farthest = 0
    n = len(stones)
    for i in range(n):
        if i > farthest:
            return False
        farthest = max(farthest, i + stones[i])
    return True
user_input = input("Enter the stones array: ")
stones = list(map(int, user_input.split(',')))
if can_reach_last_stone(stones):
    print("True")
else:
    print("False")
