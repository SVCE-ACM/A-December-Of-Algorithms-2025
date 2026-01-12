# input
n = int(input("Enter number of students: "))
scores = list(map(int, input("Enter performance scores: ").split()))

sweets = [1]*n  # every student gets at least 1

# left to right
for i in range(1, n):
    if scores[i] > scores[i-1]:
        sweets[i] = sweets[i-1] + 1

# right to left
for i in range(n-2, -1, -1):
    if scores[i] > scores[i+1]:
        sweets[i] = max(sweets[i], sweets[i+1] + 1)

# total sweets
print(sum(sweets))
