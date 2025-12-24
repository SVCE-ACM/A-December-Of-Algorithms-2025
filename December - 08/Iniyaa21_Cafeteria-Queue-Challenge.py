def countStudents(students, sandwiches):
    counts = [students.count(0), students.count(1)]
    
    for sandwich in sandwiches:
        if counts[sandwich] > 0:
            counts[sandwich] -= 1
        else:
            break
            
    return sum(counts)

students = eval(input()) 
sandwiches = eval(input()) 

print(countStudents(students, sandwiches))