def reorder(ordered,N):
    iterations = N-2
    while(iterations!=0):
        temp = ordered[1]
        for i in range(2, N):
            ordered[i-1] = ordered[i]
        ordered[N-1] = temp
        iterations -= 1
        
def oddsize(ordered,temporaryholder,N):
    temporaryholder.append(ordered[N//2])
    del ordered[N//2]
    reorder(ordered,N-1)

def print1(ordered,N):
    for i in ordered:
        print(i,end=" ")

ordered = []
temporaryholder = []

N = int(input("Enter N: "))

for i in range(N):
    v = int(input("Enter the value: "))
    ordered.append(v)
    
    
if N%2 == 0:
    reorder(ordered,N)
    print1(ordered,N)
else:
    oddsize(ordered,temporaryholder,N)
    ordered.append(temporaryholder[0])
    print1(ordered,N)
   
