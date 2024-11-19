package TTC.Model;

public class Player {
    private String name;
    private char pieceType;

    public Player(String name, char pieceType){
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getName(){
        return this.name;
    }

    public char getPieceType(){
        return this.pieceType;
    }
}
