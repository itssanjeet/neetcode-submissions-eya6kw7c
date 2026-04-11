class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])

        dirs = [[-1,0], [1,0], [0,-1], [0,1]]

        def dfs(i,j,idx):
            if idx == len(word):
                return True

            if i < 0 or j < 0 or i >= rows or j >= cols or word[idx] != board[i][j]:
                return False
            
            board[i][j] = '#'
            for dir in dirs:
                if(dfs(i+dir[0], j+dir[1], idx+1)):
                    return True
            board[i][j] = word[idx]

            return False
        
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0]:
                  if dfs(r,c,0):
                    return True

        return False



