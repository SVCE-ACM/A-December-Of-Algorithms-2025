from collections import Counter

students = list(map(int, input().split()))
sandwiches = list(map(int, input().split()))

count = Counter(students)

for s in sandwiches:
    if count[s] == 0:
        break
    count[s] -= 1

print(count[0] + count[1])
