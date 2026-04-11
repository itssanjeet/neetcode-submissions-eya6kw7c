class Solution {

    int rows, cols;
    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(backtracking(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int idx ,int i, int j){
        if(word.length() == idx){
            return true;
        }

        if(i < 0 || j < 0 || i >= rows || j >= cols 
            || word.charAt(idx) != board[i][j] || board[i][j] == '#'){
            return false;
        }

        board[i][j] = '#';

        boolean res = backtracking(board, word, idx+1, i+1, j) ||
                        backtracking(board, word, idx+1, i-1, j) ||
                        backtracking(board, word, idx+1, i, j+1) ||
                        backtracking(board, word, idx+1, i, j-1);

        board[i][j] = word.charAt(idx);

        return res;
    }
}
