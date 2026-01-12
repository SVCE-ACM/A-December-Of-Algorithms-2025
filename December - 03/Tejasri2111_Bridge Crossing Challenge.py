print("Enter the array:",end="")
stones = list(map(int, input().split()))

max_reach = 0

for i in range(len(stones)):
    if i > max_reach:
        print("false")
        break
    max_reach = max(max_reach, i + stones[i])
else:
    print("true")
