class Solution {
    public boolean exist(char[][] board, String word) {

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(word.charAt(0) == board[r][c] && solve(board, 0, r, c, word)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean solve(char[][] board, int idx, int r, int c, String word){
        if(idx == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || 
            board[r][c] != word.charAt(idx)){
                return false;
        }

        board[r][c] = '#';

        boolean b = 
            solve(board, idx+1, r+1, c, word) ||
            solve(board, idx+1, r-1, c, word) ||
            solve(board, idx+1, r, c+1, word) ||
            solve(board, idx+1, r, c-1, word);
        
        board[r][c] = word.charAt(idx);
        return b;
    }
}
