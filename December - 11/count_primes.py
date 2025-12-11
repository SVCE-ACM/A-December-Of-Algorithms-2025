N:int = int(input())

def isPrime(num:int) -> bool:
    for i in range( 2, int((num//2)+1)):
        if num % i == 0:
            return False
    print(num)
    return True
count:int = 2
if N <= 4:
    count = 2
else:
    for i in range(5 ,N+1):
        if isPrime(i):
            count = count + 1

print("The count of prime numbers less than ", N," is: ",count )
            
