N = int(input("Enter the number: "))
arr = list(map(int, input("Enter values: ").split()))

freq = [0]*100
for i in range(N-1):
    for j in range(N-i-1):
        if arr[i] > arr[i+1]:
            temp = arr[i]
            arr[i] = arr[i+1]
            arr[i+1] = temp

for i in range(N):
    freq[arr[i]] += 1

for j in range(1,len(freq)):
    if freq[j] == 0 and j<N:
        print("Missing number: ",j)
    elif freq[j] > 1:
        print("Duplicate number: ",j)
        
        
        


    
    
