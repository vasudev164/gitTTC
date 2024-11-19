package TTC.service;
import TTC.Model.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BoardService {
    int size;
    Board ttcBoard;
    ArrayList<Player> players;

    int numberOfPiecesOnBoard = 0;
    Player currentPlayer;

    Queue<Player> playerQueue;

    public BoardService(int size){
        this.size = size;
        this.ttcBoard = new Board(size);
    }

    public BoardService(int size, ArrayList<Player> players){
        this(size); // calling above constructor with size parameter
        this.setPlayers(players);
        this.playerQueue = new LinkedList<>(players);
    }

    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

    // need to optimize the below method
    private Boolean isThereAWinner(char pieceType){
        Boolean isthereawinner = false;
        for(int i=0; i<size; i++){
            isthereawinner = isthereawinner || checkRow(pieceType, i);
            isthereawinner = isthereawinner || checkCol(pieceType, i);
        }

        isthereawinner = isthereawinner || checkDiagonal(pieceType);
        isthereawinner = isthereawinner || checkAntiDiagonal(pieceType);

        return isthereawinner;
    }

    private Boolean checkRow(char pieceType, int row){
        for(int i=0; i<size; i++){
            if(this.ttcBoard.board[row][i] != pieceType){
                return false;
            }
        }
        return true;
    }

    private Boolean checkCol(char pieceType, int col){
        for(int i=0; i<size; i++){
            if(this.ttcBoard.board[i][col] != pieceType){
                return false;
            }
        }
        return true;
    }
    private Boolean checkDiagonal(char pieceType){
        for(int i=0; i<size; i++){
            if(this.ttcBoard.board[i][i] != pieceType){
                return false;
            }
        }
        return true;
    }

    private Boolean checkAntiDiagonal(char pieceType){
        for(int i=0; i<size; i++){
            if(this.ttcBoard.board[i][size-i-1] != pieceType){
                return false;
            }
        }
        return true;
    }

    private Boolean isGameFinished(){
        Boolean isThereAWinner = this.isThereAWinner(this.currentPlayer.getPieceType());
        if(isThereAWinner) return true;
        Boolean isFinished = true;
        isFinished = (this.numberOfPiecesOnBoard == size*size);
        // System.out.println(isFinished);
        // for(int i=0; i<this.size; i++){
        //     for(int j=0; j<size; j++){
        //         if(this.ttcBoard.board[i][j] == '_'){
        //             isFinished = true;
        //             break;
        //         }
        //     }
        // }
        return isFinished;
    }

    public void startGame(){

        do{
            this.currentPlayer = playerQueue.peek();
            Scanner sc = new Scanner(System.in);
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            char pieceType = this.currentPlayer.getPieceType();
            boolean isPieceAdded = this.ttcBoard.addPiece(x, y, pieceType);
            this.ttcBoard.printBoard();
            if(isPieceAdded){
                playerQueue.remove();
                playerQueue.add(this.currentPlayer);
                this.numberOfPiecesOnBoard++;
            }else{
                System.out.println("Something wrong about input given. Please correct it!!!");
            }
        }while(!this.isGameFinished());

        if(isThereAWinner(this.currentPlayer.getPieceType())){
            System.out.println(this.currentPlayer.getName() + "won the game.");
        }else{
            System.out.println("Draw match!!!");
        }
    }
}
