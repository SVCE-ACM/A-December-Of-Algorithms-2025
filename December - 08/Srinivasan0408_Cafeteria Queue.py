students_str = input("students = ").strip()
sandwiches_str = input("sandwiches = ").strip()
students_str = students_str[1:-1]
sandwiches_str = sandwiches_str[1:-1]
students = list(map(int, students_str.split(',')))
sandwiches = list(map(int, sandwiches_str.split(',')))
count0 = students.count(0)
count1 = students.count(1)
for s in sandwiches:
    if s == 0:
        if count0 == 0:
            break
        count0 -= 1
    else:
        if count1 == 0:
            break
        count1 -= 1
print(count0 + count1)