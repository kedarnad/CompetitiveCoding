package connectFour;

import java.util.Scanner;

public class HumanPlayer implements ConnectFourPlayerInterface {
    private static int chance = 0;
    private String name;
    private char game_piece;
    private int playerNo, NoOfwins = 0;
    private boolean wins;

    public HumanPlayer(String bob) {
        this.name = bob;
        wins = false;
        NoOfwins = 0;
    }


    @Override
    public int takeTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + "Select a collumn");
        int colNo = parseToNumber(scanner.nextLine());
        return validateColumn(colNo) >= 0 ? colNo : takeTurn();
    }

    private int validateColumn(int colNo) {
        if (colNo <= 6 && colNo > -1) {
            return colNo;
        } else {
            System.out.println("Invalid Column");
            return -1;
        }
    }

    private int parseToNumber(String nextLine) {
        try {
            return Integer.parseInt(nextLine);
        } catch (NumberFormatException ne) {
            return -1;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumberOfWins() {
        return NoOfwins;
    }

    @Override
    public void addWin() {
        NoOfwins++;
        wins = true;
    }

    @Override
    public char getGamePiece() {
        return game_piece;
    }

    @Override
    public void setGamePiece(char gamePiece) {
        this.game_piece = gamePiece;
    }

    @Override
    public void setPlayerNumber(int num) {
        this.playerNo = num;
    }

    @Override
    public boolean hasWon() {
        return wins;
    }
}
