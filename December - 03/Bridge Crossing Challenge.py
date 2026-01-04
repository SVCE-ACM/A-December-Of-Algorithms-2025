stone = []

N = int(input("Enter number of stones: "))

for i in range(N):
    x = int(input("Enter the number of jumps: "))
    stone.append(x)
print(stone)

max_reach = 0

for i in range(N):
    if i > max_reach:
        print("False")
        break

    max_reach = max(max_reach, i + stone[i])

    if max_reach >= N - 1:
        print("True")
        break
