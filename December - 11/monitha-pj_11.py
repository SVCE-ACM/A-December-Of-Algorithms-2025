N=int(input("Enter N:"))
count=0
for i in range(2,N):
    is_prime=True
    for j in range(2,int(i/2)+1):
        if i%j==0:
            is_prime=False
            break
    if is_prime:
        count+=1
print("The count of prime numbers less than",N,"is :",count) 
        
