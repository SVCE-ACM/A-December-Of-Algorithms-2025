n = int(input("Enter N: "))
def check(n):
    if n<=1:
        return False 
    for i in range(2,int(n**0.5)+1):
        if n%i==0:
            return False 
    return True
c=0
for i in range(1,n+1):
    if check(i):
        c+=1
print("The count of prime numbers less than 10 is:",c)