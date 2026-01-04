n = int(input("Enter the number of operations: "))
score = []

total = 0

for i in range(n):
    x = input("Add the score value to the record: ")

    if x.isdigit():                     
        score.append(int(x))
        total = total + int(x)

    elif x == '+':                      
        val = score[-1] + score[-2]
        score.append(val)
        total = total + val

    elif x == 'D':                      
        val = 2 * score[-1]
        score.append(val)
        total = total + val

    elif x == 'C':                      
        removed = score.pop()
        total = total - removed

print("Total score:", total)
