from collections import deque

def countStudents(students, sandwiches):
    students = deque(students)
    sandwiches = deque(sandwiches)
    
    rotations = 0  
    
    while students and rotations < len(students):
        if students[0] == sandwiches[0]:
            students.popleft()
            sandwiches.popleft()
            rotations = 0  
        else:
            students.append(students.popleft())
            rotations += 1 

    return len(students)

students = list(map(int, input("Enter students (0 or 1) separated by space: ").split()))
sandwiches = list(map(int, input("Enter sandwiches (0 or 1) separated by space: ").split()))

print(countStudents(students, sandwiches))
