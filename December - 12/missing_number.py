N = int(input())
nums = list(map(int, input().split()))

i = 0
while i < len(nums):
    correct = nums[i] - 1
    if nums[i] != nums[correct]:
        nums[i], nums[correct] = nums[correct], nums[i]
    else:
        i += 1

missing = duplicate = None

for i in range(len(nums)):
    if nums[i] != i + 1:
        duplicate = nums[i]
        missing = i + 1
        break

print("Missing Number:", missing)
print("Duplicate Number:", duplicate)
