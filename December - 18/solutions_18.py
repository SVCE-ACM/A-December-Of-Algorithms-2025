N = int(input("Enter the number of beads: "))
if N==0:
    print("The necklace is empty")
else:
    beads = list(map(int, input("Enter the bead numbers: ").split()))
    capacity = N
    if N%2==0:
        N = N//2
    else:
        N = (N//2)+1 
 
    count = 0
    for i in range(N):
        if beads[i] == beads[capacity-1-i]:
            count += 1 

    if count == N:
        print("The necklace is mirrored")
    else:
        print("The necklace is not mirrored")
