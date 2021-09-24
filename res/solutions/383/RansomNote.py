class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        magazine_dict = {}
        flag = 0
        for each_char in magazine:
            if each_char not in magazine_dict:
                magazine_dict[each_char] = 1
            else:
                magazine_dict[each_char] += 1
        for each_char in ransomNote:
            if each_char in magazine_dict and magazine_dict[each_char]>0:
                magazine_dict[each_char] -= 1
            else:
                flag = 1
                break
        if(flag == 1):
            return False
        return True


solution = Solution()
print(solution.canConstruct("aabb", "baab"))
