n=int(input("enter range"))
for i in range(1,n+1):
    o=str(oct(i))
    h=str(hex(i))
    b=str(bin(i))
    print(i,(o[2:]),(h[2:]).upper(),(b[2:]),sep="     ")
