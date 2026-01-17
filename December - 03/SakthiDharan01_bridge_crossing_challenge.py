import sys
import re

def parse_array(data: str):
    nums = list(map(int, re.findall(r"-?\d+", data)))
    if not nums:
        return []
    if len(nums) > 1 and nums[0] == len(nums) - 1:
        return nums[1:]
    return nums

def can_reach(arr):
    far = 0
    for i, v in enumerate(arr):
        if i > far:
            return False
        far = max(far, i + v)
        if far >= len(arr) - 1:
            return True
    return far >= len(arr) - 1

def solve():
    data = sys.stdin.read()
    arr = parse_array(data)
    if not arr:
        return
    print(str(can_reach(arr)).lower())

if __name__ == "__main__":
    solve()
