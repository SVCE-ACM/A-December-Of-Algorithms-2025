n = int(input("Enter the number:"))
i,l=1,len(bin(n)[2:])  #len-->space between the columns
while(i<=n):
    print(str(i).rjust(l),oct(i)[2:].rjust(l),hex(i)[2:].upper().rjust(l),bin(i)[2:].rjust(l))
    i +=1
