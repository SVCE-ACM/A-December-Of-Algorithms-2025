N:int = int(input())
nums:list[int] = list(map(int, input().split()))
num_dict = {}

for num in nums:
    count:int = 1
    if num in num_dict:
        count = num_dict[num] + 1
    num_dict[num] = count

distinct_element_count:int = 0

for num in nums:
    if( num_dict[num] == 1):
        distinct_element_count = distinct_element_count + num
print(distinct_element_count)