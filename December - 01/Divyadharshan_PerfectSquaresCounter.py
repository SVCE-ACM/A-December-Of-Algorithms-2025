N = int(input())
perfectSqaures = []

for i in range(1,N+1):
    sqrt=int(i**0.5)
    if sqrt*sqrt==i:
        perfectSqaures.append(i)
        
print(*perfectSqaures)
print(len(perfectSqaures))