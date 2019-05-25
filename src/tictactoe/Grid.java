package tictactoe;
//start enum

public class Grid{

    private GamePiece[][] grid = new GamePiece[3][3];

    public Grid(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = null; // null is an empty space
            }
        }
    }

    public boolean setPiece(int posX, int posY, GamePiece piece){
        boolean isSet = false;
        if(grid[posY][posX] == null){
            grid[posY][posX] = piece;
            isSet = true;
        }
        return isSet;
    }

    public void printBoard(){
        System.out.println();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == null){
                    if(j < 2){
                        System.out.print("    |");
                    }else{
                        System.out.print("    ");
                    }
                }else{
                    if(j < 2){
                        System.out.printf(" %s |", grid[i][j]);
                    }else{
                        System.out.printf(" %s ", grid[i][j]);
                    }
                }
            }
            System.out.println(); //New Line
            if(i < 2){
                System.out.println("--------------");
            }
        }
        System.out.println();
    }

    public int checkForWinner(){
        //-1 = No Winner
        //-2 = Draw
        //1 = X Won
        //0 = O Won
        int result = -1;
        GamePiece vertical = checkVertical();
        GamePiece horizontal = checkHorizontal();
        GamePiece diaganol = checkDiaganol();

        if(vertical == GamePiece.Xs || horizontal == GamePiece.Xs || diaganol == GamePiece.Xs){
            result = 1;
            return result; // X's Won
        }else if(vertical == GamePiece.Os || horizontal == GamePiece.Os || diaganol == GamePiece.Os){
            result = 0;
            return result; // O's Won
        }else{
            return result; // No Winner
        }
    }

    private GamePiece checkVertical(){
        for(int i = 0; i < grid.length; i++){
            if((grid[0][i] == grid[1][i]) && (grid[0][i] == grid[2][i])){
                return grid[0][i];
            }
        }
        return null;
    }

    private GamePiece checkHorizontal(){
        for(int i = 0; i < grid.length; i++){
            if((grid[i][0] == grid[i][1]) && (grid[i][0] == grid[i][2])){
                return grid[i][0];
            }
        }
        return null;
    }

    private GamePiece checkDiaganol(){
        if((grid[0][0] == grid[1][1]) && (grid[0][0] == grid[2][2])){
            return grid[0][0];
        }
        if((grid[0][2] == grid[1][1]) && (grid[0][2] == grid[2][0])){
            return grid[0][2];
        }
        return null;
    }

    private boolean checkDraw(){
        boolean check = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == GamePiece.Xs || grid[i][j] == GamePiece.Os){
                    check = true;
                    return check;
                }
            }
        }
    }

}
