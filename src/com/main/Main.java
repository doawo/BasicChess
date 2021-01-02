package com.main;

import board.Board;
import game.*;
import datatypes.*;
import enums.*;
import account.*;
import pieces.Bishop;
import pieces.Piece;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Player1 creation
        Address eva_address = new Address("Baker st", "London", "", "01203", "United Kingdom");
        Person eva = new Person("Eva", "eva@gmail.com", "+7771110932", eva_address);

        //Player2 creation
        Address jake_address = new Address("Oxford st.", "London", "", "02133", "United Kingdom");
        Person jake = new Person("Jake", "jake@gmail.com", "+7771115123", jake_address);

        //Admin creation
        Admin admin = new Admin(0, "root12345", AccountStatus.ACTIVE);

        //Players init
        Player evaPl = new Player(1, "evaChessMaster", AccountStatus.ACTIVE, eva, 0);
        Player jakePl = new Player(2, "jakenBake00", AccountStatus.ACTIVE, jake, 0);

        Scanner sc = new Scanner(System.in);

        GameView.welcomeMessage();

        int action = sc.nextInt();

        Game game = new Game();

        if(action == 1){
            game.newGame(evaPl, jakePl);
        }

    }
}
