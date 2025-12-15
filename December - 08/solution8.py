students=  list(map(int,input("enter students:").split()))
sandwiches=  list(map(int,input("enter sandwiches:").split()))
def countstudents(students,sandwiches):
    want0=students.count(0)
    want1=len(students)-want0
    for s in sandwiches:
        if s==0:
            if  want0 == 0:
                return want1
            want0-=1
        else:
            if  want1 == 0:
                return want0
            want1-=1
    return 0 
result=countstudents(students,sandwiches)
print(f"No of students who cant eat:{result}")

enter students:1 1 1 0 0 1
enter sandwiches:1 0 0 0 1 1
No of students who cant eat:3
