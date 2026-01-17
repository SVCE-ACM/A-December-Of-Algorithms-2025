"""You are given a collection of numbers and a target value. Your task is to find a contiguous segment of numbers in the collection whose sum equals the target.

- If such a segment exists, report the starting and ending indices (0-based) of any one segment.
- If no such segment exists, report -1 -1."""
def find_segments(nums,target):
    prefix_sum = 0
    visited = {0:-1}
    for idx,num in enumerate(nums):
        prefix_sum += num
        if (prefix_sum - target) in visited:
            return visited[prefix_sum -target] +1, idx
        visited[prefix_sum] = idx
    return -1,-1
#main prog;
nums = list(map(int,input().split()))
target = int(input())
start,end = find_segments(nums,target)
print(start,end)