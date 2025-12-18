num_beads = int(input())
if num_beads == 0:
    print("The necklace is empty.")
else:
    necklace = list(map(int, input().split()))
    if necklace == necklace[::-1]:
        print("The necklace is mirrored.")
    else:
        print("The necklace is not mirrored.")
