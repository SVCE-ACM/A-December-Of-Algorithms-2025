n = int(input("N = ").strip())
if n == 0:
    print("The necklace is empty.")
    exit()
beads = list(map(int, input("Beads = ").strip().split()))
if beads == beads[::-1]:
    print("The necklace is mirrored.")
else:
    print("The necklace is not mirrored.")