/**
 *  Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
    A region is captured by flipping all'O's into'X's in that surrounded region .
 X X X X
 X O O X
 X X O X
 X O X X
 return:
 X X X X
 X X X X
 X X X X
 X O X X

 * 所有与四条边相连的O都保留，其他O都变为X
 * 遍历四条边上的O，并深度遍历与其相连的O，将这些O都转为*
 * 将剩余的O变为X
 * 将剩余的*变为O
 */

public class surrounded_regions {
    public int rowNum = 0;
    public int colNum = 0;

    public void solve(char[][] board) {
        if(board == null || board.length<=0 || board[0].length<=0){
            return;
        }
        rowNum = board.length;//行
        colNum = board[0].length;//列

        for(int i = 0; i < colNum; i++){
            dfs(board, 0, i);
            dfs(board, rowNum-1, i);
        }
        for(int i = 0; i < rowNum; i++){
            dfs(board, i, 0);
            dfs(board, i, colNum-1);
        }
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int row, int col) {
        if(board[row][col] == 'O'){
            board[row][col] = '*';
            if(row > 1){
                dfs(board, row-1, col);
            }
            if(col > 1){
                dfs(board, row, col-1);
            }
            if(row < rowNum-1){
                dfs(board, row+1, col);
            }
            if(col < colNum-1){
                dfs(board, row, col+1);
            }
        }
    }
}
