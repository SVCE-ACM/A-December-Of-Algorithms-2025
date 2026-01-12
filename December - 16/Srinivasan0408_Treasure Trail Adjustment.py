s=input().strip()
left, right = s.split("],")
arr_str = left.split("=")[1].strip()
arr_str = arr_str[1:]          
nums = list(map(int, arr_str.split(",")))
n = int(right.split("=")[1].strip())
idx = len(nums)-n
nums.pop(idx)
print(nums)