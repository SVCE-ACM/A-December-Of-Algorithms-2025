n=int(input("enter total beads"))
if n==0:
    print("the necklace is empty")
else:
    s=input("enter sequence")
    if s==s[::-1]:
        print("the necklace is mirrored")
    else:
        print("the necklace is not mirrored")
