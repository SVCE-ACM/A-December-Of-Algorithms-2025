def count_students_unable_to_eat(students, sandwiches):
    count0 = students.count(0)
    count1 = students.count(1)
    for sandwich in sandwiches:
        if sandwich == 0 and count0 > 0:
            count0 -= 1
        elif sandwich == 1 and count1 > 0:
            count1 -= 1
        else:
            break
    return count0 + count1
students_input = input("Enter student preferences : ")
sandwiches_input = input("Enter sandwich stack: ")
students = [int(x.strip()) for x in students_input.split(",")]
sandwiches = [int(x.strip()) for x in sandwiches_input.split(",")]
result = count_students_unable_to_eat(students, sandwiches)
print(result)
