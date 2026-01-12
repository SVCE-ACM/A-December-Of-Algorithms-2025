arr=eval(input("root=").replace("null","None"))
length=len(arr)
null=False
for i in range(length):
    if arr[i] == None:
        null=True
    else:
        if null ==True:
            print("false")
            break
else:
    print("true")
