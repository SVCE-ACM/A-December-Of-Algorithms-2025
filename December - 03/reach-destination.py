def will_reach_destination(nums: list[int]) -> bool:
    i:int = 0;
    while( i < len(nums)):
        print("loop running")
        if( nums[i] == 0 and i != (len(nums) - 1)):
            return False
        if( i == len(nums) - 1):
            return True
        i = i + nums[i]
    if( i >= len(nums)):
        return False
    return True

print(will_reach_destination([2,3,1,1,4])) 