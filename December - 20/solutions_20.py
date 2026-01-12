def compare(towers, index):
    flag = 0
    for i in range(index + 1, len(towers)):
        if towers[i] > towers[index]:
            print(towers[i],end=" ")
            flag = 1
            break
    if flag == 0:
        print("-1",end=" ")

N = int(input("Enter the number of towers: "))
towers = list(map(int, input("Enter the tower height: ").split()))

for i in range(len(towers)):
    compare(towers, i)
