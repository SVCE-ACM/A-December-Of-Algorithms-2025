n = int(input().split('=')[1].strip())
if n == 0:
    print("The necklace is empty.")
    exit()
beads = list(map(int, input().split('=')[1].strip().split()))
if beads == beads[::-1]:
    print("The necklace is mirrored.")
else:
    print("The necklace is not mirrored.")