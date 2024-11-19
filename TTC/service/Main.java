package TTC.service;
import TTC.service.*;
import TTC.Model.*;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int size;
        ArrayList<Player> players = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int numberOfPlayers = sc.nextInt();
        size = sc.nextInt();

        for(int i=0; i<numberOfPlayers; i++){
            char pieceType;
            String name;
            pieceType = sc.next().charAt(0);
            name = sc.next();
            Player player = new Player(name, pieceType);
            players.add(player);
        }

        BoardService boardService = new BoardService(size, players);
        //boardService.setPlayers(players);
        boardService.startGame();
    }
}
