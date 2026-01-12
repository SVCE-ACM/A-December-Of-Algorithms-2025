n = int(input("Enter the size: "))
stones = []

for i in range(n):
    v = int(input("Enter the value: "))
    stones.append(v)

maxReach = 0

for i in range(n):
    if i > maxReach:
        print("false")
        break
    maxReach = max(maxReach, i + stones[i])
else:
    if maxReach >= n - 1:
        print("true")
    else:
        print("false")
