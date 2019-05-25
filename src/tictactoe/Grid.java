package tictactoe;

public class Grid{

    private int[][] grid = new int[3][3];

    public Grid(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = -1; // -1 is an empty space
            }
        }
    }

    public boolean setPiece(int posX, int posY, int piece){
        boolean isSet = false;
        if(grid[posY][posX] == -1){
            grid[posY][posX] = piece;
            isSet = true;
        }
        return isSet;
    }

    public void printBoard(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int checkForWinner(){
        //-1 = Winner
        //1 = ... Won
        //2 = ... Won
        int result = -1;
        int vertical = checkVertical();
        int horizontal = checkHorizontal();
        int diaganol = checkDiaganol();

        if(vertical == 1 || horizontal == 1 || diaganol == 1){
            result = 1;
            return result; // ... Won
        }else if(vertical == 0 || horizontal == 0 || diaganol == 0){
            result = 0;
            return result; // ... Won
        }else{
            return result; // No Winner
        }
    }

    private int checkVertical(){
        for(int i = 0; i < grid.length; i++){
            if((grid[0][i] == grid[1][i]) && (grid[0][i] == grid[2][i])){
                return grid[0][i];
            }
        }
        return -1;
    }

    private int checkHorizontal(){
        for(int i = 0; i < grid.length; i++){
            if((grid[i][0] == grid[i][1]) && (grid[i][0] == grid[i][2])){
                return grid[i][0];
            }
        }
        return -1;
    }

    private int checkDiaganol(){
        if((grid[0][0] == grid[1][1]) && (grid[0][0] == grid[2][2])){
            return grid[0][0];
        }
        if((grid[0][2] == grid[1][1]) && (grid[0][2] == grid[2][0])){
            return grid[0][2];
        }
        return -1;
    }

}
