N=int(input("N="))
if N==0:
    print("The necklace is empty.")
beads=list(map(int,input("Beads=").split()))
if beads[:]==beads[: :-1]:
    print("The necklace is mirrored.")
else:
    print("The necklace is not mirrored.")
