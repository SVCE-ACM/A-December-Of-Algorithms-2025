import math
def prime(n):
    count=0
    for j in range(2,n):
        for i in range(2,int(math.sqrt(j)+1)):
            if j%i==0:
                break
        else:
            count+=1
    return count
n = int(input())
print("The count of prime numbers less than N is:",prime(n))
            