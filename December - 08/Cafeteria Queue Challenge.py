students = list(map(int, input().split()))  
sandwiches = list(map(int, input().split()))

from collections import deque

students = deque(students)
sandwiches = deque(sandwiches)

while students and sandwiches:
    count = 0
    length = len(students)
    while count < length:
        if students[0] == sandwiches[0]:
            students.popleft()
            sandwiches.popleft()
            break
        else:
            students.append(students.popleft())
            count += 1
    else:
        break

print(len(students))
