N = int(input("Enter number of beads: "))

if N == 0:
    print("The necklace is empty.")
else:
    beads = list(map(int, input("Enter bead numbers: ").split()))

    if beads == beads[::-1]:
        print("The necklace is mirrored.")
    else:
        print("The necklace is not mirrored.")
