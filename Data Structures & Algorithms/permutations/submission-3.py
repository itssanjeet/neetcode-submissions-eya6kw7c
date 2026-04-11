class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        res = [[]]

        for num in nums:
            new_perms = []
            for r in res:
                for i in range(len(r)+1):
                    p_copy = r.copy()
                    p_copy.insert(i, num)
                    new_perms.append(p_copy)
            
            res = new_perms
        
        return res