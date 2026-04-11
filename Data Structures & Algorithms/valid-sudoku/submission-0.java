class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(!isValid(board, i, j, board[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int r, int c, char t){
        for(int i=0; i<9; i++){
            if(i != c && board[r][i] == t){
                return false;
            }

            if(i != r && board[i][c] == t){
                return false;
            }
        }

        int startRow = 0, endRow = 3;
        if(r >= 0 && r <= 2){
            startRow = 0;
            endRow = 2;
        } else if(r >= 3 && r <= 5){
            startRow = 3;
            endRow = 5;
        } else {
            startRow = 6;
            endRow = 8;
        }

        int startCol = 0, endCol = 0;
        if(c >= 0 && c <= 2){
            startCol = 0;
            endCol = 2;
        } else if(c >= 3 && c <= 5){
            startCol = 3;
            endCol = 5;
        } else {
            startCol = 6;
            endCol = 8;
        }

        for(int i=startRow; i<=endRow; i++){
            for(int j=startCol; j<=endCol; j++){
                if(i == r && j == c){
                    continue;
                }

                if(board[i][j] == t){
                    return false;
                }
            }
        }

        return true;
    }
}
