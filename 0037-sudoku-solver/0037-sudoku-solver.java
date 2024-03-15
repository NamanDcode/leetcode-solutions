class Solution {
    public void solveSudoku(char[][] board) {
        copy(solve(board,0,0,new char[9][9]),board);
    }
    public static char[][] copy(char[][] a,char[][] b){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                b[i][j]=a[i][j];
            }
        }
        return b;
    }
    public static char[][] solve(char[][] grid,int row,int col,char[][] ans){
        if(col==grid[0].length){
            col=0;
            row++;
        }
        if(row==grid.length){
            copy(grid,ans);
            return ans;
        }
        if(grid[row][col]!='.') solve(grid,row,col+1,ans);
        else{
            for(char i='1';i<='9';i++){
                if(check(grid,row,col,i)){
                    grid[row][col]=i;
                    solve(grid,row,col+1,ans);
                    grid[row][col]='.';
                }
            }
        }
        return ans;
    }
    public static boolean check(char[][] grid,int row,int col,char v){
        for(int i=0;i<grid.length;i++){
            if(grid[i][col]==v) return false;
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[row][i]==v) return false;
        }
        int r= row-row%3;
        int c= col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(grid[i][j]==v) return false;
            }
        }
        return true;
    }
}