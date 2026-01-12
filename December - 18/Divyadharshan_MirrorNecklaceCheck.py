def isMirroredNecklace(n, beads):
    if n == 0:
        print("The necklace is empty.")
    elif beads == beads[::-1]:
        print("The necklace is mirrored.")
    else:
        print("The necklace is not mirrored.")
n = int(input())
beads = [int(i) for i in input().split()]
isMirroredNecklace(n, beads)