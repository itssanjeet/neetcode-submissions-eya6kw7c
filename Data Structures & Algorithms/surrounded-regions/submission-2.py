class Solution:
    def solve(self, board: List[List[str]]) -> None:
        rows, cols = len(board), len(board[0])
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]

        def fillT(r,c):
            if r < 0 or c < 0 or r >= rows or c >= cols or board[r][c] != 'O':
                return

            board[r][c] = 'T'
            for dir in dirs:
                nr = dir[0] + r
                nc = dir[1] + c
                fillT(nr, nc)
        
        for r in range(rows):
            if board[r][0] == 'O':
                fillT(r, 0)

            if board[r][cols-1] == 'O':
                fillT(r, cols-1)

        for c in range(cols):
            if board[0][c] == 'O':
                fillT(0, c)

            if board[rows-1][c] == 'O':
                fillT(rows-1, c)

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 'T':
                    board[r][c] = 'O'

                elif board[r][c] == 'O':
                    board[r][c] = 'X'       


