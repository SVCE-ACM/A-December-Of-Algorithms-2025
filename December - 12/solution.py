N=int(input("Enter N:"))
summ=N*(N+1)//2
arr=list(map(int,input().split()))
for i in arr:
    if arr.count(i)>1:
        duplicate_no=i
sum_arr=sum(arr)-duplicate_no
missing_no=summ-sum_arr
print("Missing number=",missing_no)
print("Duplicate number=",duplicate_no)
        
