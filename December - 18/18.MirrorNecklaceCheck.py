N = int(input("Enter number of beads (N): "))
if N == 0:
    print("The necklace is empty.")
else:
    beads = list(map(int, input("Enter the bead numbers: ").split()))
    
    if len(beads) != N:
        print("Error: Number of beads does not match N.")
    else:
        if beads == beads[::-1]:
            print("The necklace is mirrored.")
        else:
            print("The necklace is not mirrored.")
