arr=input("stones = ").strip()
arr=arr[1:-1]
stone=list(map(int,arr.split(',')))
reach=0
for i in range(len(stone)):
    if i>reach:
        print("false")
        break
    reach=max(reach,i+stone[i])
else:
    print("true")