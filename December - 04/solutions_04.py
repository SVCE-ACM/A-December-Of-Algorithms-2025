def find_subarray(nums, K):
    pref = 0
    mp = {0: -1}  

    for i, x in enumerate(nums):
        pref += x

        if pref - K in mp:
            return mp[pref - K] + 1, i 

        mp[pref] = i

    return -1, -1

nums=[]
n = int(input("Enter the number of elements: "))
for i in range(n):
  v = int(input("Enter the value: "))
  nums.append(v)
 K =int(input("Enter the target sum: "))
find_subarray(nums,k)
