def find_max(skills, N, new):
    max1 = skills[0]
    
    for i in range(1, len(skills)):
        if skills[i] > max1:
            max1 = skills[i]
    new.append(max1)
    del skills[skills.index(max1)]
    return new, skills

def compare(skills, new, index, min_dif, total):  
    if index >= len(skills):
        sum_new = sum(new)
        sum_other = total - sum_new  
        diff = abs(sum_new - sum_other)
        min_dif.append(diff)
        return

    new.append(skills[index])
    compare(skills, new, index + 1, min_dif, total)
    new.pop()  

    compare(skills, new, index + 1, min_dif, total)

N = int(input("Enter the number of employees: "))
skills = list(map(int, input("Enter the skill level: ").split()))
total = sum(skills)  
new = []
find_max(skills, N, new)  
min_dif = []
compare(skills, new, 0, min_dif, total)  

if len(min_dif) > 0:
    min1 = min_dif[0]
    for i in range(len(min_dif)):
        if min_dif[i] < min1:
            min1 = min_dif[i]
    print(min1)
else:
    print("No valid split found")
