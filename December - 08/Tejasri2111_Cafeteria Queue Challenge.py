from collections import deque

def countStudentsCannotEat(students, sandwiches):
    queue = deque(students)
    stack = sandwiches[:]  # copy of sandwiches
    
    count = 0  # to track consecutive students who can't eat
    
    while queue and count < len(queue):
        if queue[0] == stack[0]:
            queue.popleft()
            stack.pop(0)
            count = 0  # reset since someone ate
        else:
            queue.append(queue.popleft())
            count += 1
    
    return len(queue)

# Taking input from user
students = list(map(int, input("Enter student preferences (0 or 1) separated by space: ").split()))
sandwiches = list(map(int, input("Enter sandwiches stack (0 or 1) separated by space, top first: ").split()))

result = countStudentsCannotEat(students, sandwiches)
print("Number of students who cannot eat:", result)
