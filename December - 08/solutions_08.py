def queue1(student,sandwiches):
    
    temp = student[0]
    for i in range(1,len(student)):
        student[i-1] = student[i]
    student[len(student)-1] = temp
    return student
    
def similarity(student,sandwiches):
    count1 = 0
    max_iterations = len(student) * len(student)
    while count1 < max_iterations and len(student) > 0:
        if student[0] == sandwiches[0]:
            del student[0]
            del sandwiches[0]
            count1 = 0
        else:
            queue1(student,sandwiches)
            count1 += 1
            
    if student != []  and sandwiches != []:
        print(len(student))
    else:
        print(0)

student = []
sandwiches = []

n = int(input("Enter the length of both the student and the sandwiches array: "))
for i in range(2):
    if(i==0):
        print("\nStudents array\n")
        for j in range(n):
            s1 = int(input("Enter the value: "))
            student.append(s1)
    else:
        print("\nSandwiches array");
        for k in range(n):
            s2 = int(input("Enter the value: "))
            sandwiches.append(s2)
            
if all(x in {0,1} for x in student) and all(x in {0,1} for x in sandwiches and len(student)>=1 and len(student)<=100 and len(sandwiches)>=1 and len(sandwiches)<=100):
    
    similarity(student,sandwiches)
else:
    print("The student and sandwiches array will only accept 0s or 1s")

