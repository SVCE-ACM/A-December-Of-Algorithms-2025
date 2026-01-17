from collections import deque

def countStudents(students, sandwiches):
    students = deque(students)
    sandwiches = deque(sandwiches)
    attempts = 0 
    while students and sandwiches:
        if students[0] == sandwiches[0]:
            students.popleft()
            sandwiches.popleft()
            attempts = 0
        else:
            students.append(students.popleft())
            attempts += 1
        if attempts == len(students):
            break
    
    return len(students)
students = list(map(int,input().split()))
sandwiches = list(map(int,input().split()))
print(countStudents(students, sandwiches))
