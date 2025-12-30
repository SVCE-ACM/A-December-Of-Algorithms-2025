def countStudents(students, sandwiches):
    count = {0: 0, 1: 0}
    for s in students:
        count[s] += 1
    for sand in sandwiches:
        if count[sand] == 0:
            break
        count[sand] -= 1
    return count[0] + count[1]
students = list(map(int, input().split()))
sandwiches = list(map(int, input().split()))
print(countStudents(students, sandwiches))
