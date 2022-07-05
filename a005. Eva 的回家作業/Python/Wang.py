for i in range(int(input())):
    nums = list(map(int, input().split()))
    print(*nums, end=" ")
    if(nums[0] + nums[3] == nums[1] + nums[2]):
        print(int(nums[3] + (nums[1] - nums[0])))
    else:
        print(int(nums[3] * (nums[1] / nums[0])))
