def sorting(packages, sorted_list):
    temp = packages.pop(0)  
    packages.append(temp)   
    Queue1(packages, min(packages), sorted_list)
    
def Queue1(packages, min1, sorted_list):
    if packages != []:
        if packages[0] == min1:
            sorted_list.append(packages[0])
            del packages[0]
            if packages != []: 
                Queue1(packages, min(packages), sorted_list)
            else:
                Queue1(packages, None, sorted_list)  
        else:
            sorting(packages, sorted_list)
    else:
        for i in range(len(sorted_list)):
            print(sorted_list[i], end=" ")
            
N = int(input("Enter the number of packages: "))
packages = list(map(int, input("Enter the package weights: ").split()))
sorted_list = []
Queue1(packages, min(packages), sorted_list)
