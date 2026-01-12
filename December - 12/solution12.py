 
n = int(input("enter the number of elements:"))
arr = list(map(int,input("enter elements:").split()))

def find_missing_and_duplicate(arr,n):
    duplicate =None
    missing=None
for i in range(n):
   x=abs(arr[i])
   if arr[x-1]<0:
     duplicate = x
   else: 
     arr[x-1] = -arr[x-1]
for i in range(n):
   if arr[i] > 0:
      missing = i+1
      break
print(f"missing:{missing}")
print(f"duplicate:{duplicate}")

find_missing_and_duplicate(arr,n) 

enter the number of elements:4
enter elements:3 2 2 1
missing:4
duplicate:2