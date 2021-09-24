class Solution:
    def removeDuplicates(self, nums) -> int:
        i = 1
        j = 1
        while(i < len(nums)):
            if(nums[i-1] != nums[i]):
                nums[j] = nums[i]
                j += 1
            i += 1
        while(j < len(nums)):
            del nums[j]
        return len(nums)

solution = Solution()
print(solution.removeDuplicates([0,0,1,1,1,2,2,3,3,4]))