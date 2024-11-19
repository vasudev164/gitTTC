package TTC.Model;

public class Board {
    public char[][] board;
    private int size;

    public Board(int size){
        this.size = size;
        this.board = new char[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                this.board[i][j] = '_';
            }
        }
    }

    public boolean addPiece(int x, int y, char pieceType){
        if(!(x >= 0 && x < size && y >= 0 && y < size)){
            return false;
        }
        if(this.board[x][y] != '_'){
            return false;
        }
        this.board[x][y] = pieceType;
        return true;
    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
    }
}