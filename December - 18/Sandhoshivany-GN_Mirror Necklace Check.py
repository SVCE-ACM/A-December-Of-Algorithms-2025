def mirrorNecklaceCheck(n, beads):
    if n == 0:
        print("The necklace is empty.")
        return
    if beads == beads[::-1]:
        print("The necklace is mirrored.")
    else:
        print("The necklace is not mirrored.")

if __name__ == "__main__":
    n = int(input().strip())
    if n > 0:
        beads = list(map(int, input().strip().split()))
    else:
        beads = []
    mirrorNecklaceCheck(n, beads)
