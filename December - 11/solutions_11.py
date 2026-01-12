N = int(input("Enter the number: "))
count1=0
for i in range(2,N):
    if i==2:
        count1 += 1
    else:
        j=1
        count2=0
        while j<=i:
            if i%j==0:
                count2 += 1
            j += 1
        if count2 == 2:
            count1 += 1
print("The count of prime numbers less than ",N," is ",count1)
