package connectFour;

import java.util.Scanner;

public class ConnectFourGame implements ConnectFourGameInterface {

    private static char[][] charMatrix = new char[6][7];
    private static int chance = 0;
    Scanner sc = new Scanner(System.in);
    private HumanPlayer hp[] = new HumanPlayer[2];
    private String regexPlayer1, regexPlayer2;
    private String type1, type2;

    public ConnectFourGame(ConnectFourPlayerInterface player1, ConnectFourPlayerInterface player2) {
        MatrixInit();
        hp[0] = (HumanPlayer) player1;
        hp[1] = (HumanPlayer) player2;
        this.initTheGame(hp[0], hp[1]);
    }

    public static void MatrixInit() {
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix[i].length; j++) {
                charMatrix[i][j] = '.';
            }
        }
    }

    public int initFirstChoice() {
        double choice = Math.random();
        if (choice >= 0.5)
            chance = 1;
        else
            chance = 0;
        return chance;
    }

    public void initTheGame(HumanPlayer h1, HumanPlayer h2) {
        this.hp[0] = h1;
        this.hp[1] = h2;
        setGamePiece(this.hp[0]);
        setGamePiece(this.hp[1]);

        regexPlayer1 = ".*" + type1 + type1 + type1 + type1 + ".*";

        regexPlayer2 = ".*" + type2 + type2 + type2 + type2 + ".*";

    }

    private void setGamePiece(ConnectFourPlayerInterface player) {
        do {
            System.out.println(player.getName() + "Select your Charachter for player: " +
                    "game piece: ");
        } while (!validGamePiece(sc.next(), player));
    }

    public boolean validGamePiece(String userInput, ConnectFourPlayerInterface player) {
        if (userInput.charAt(0) != ' '
                && userInput.charAt(0) != hp[0].getGamePiece()
                && userInput.charAt(0) != hp[1].getGamePiece()) {
            player.setGamePiece(userInput.charAt(0));
            return true;
        }
        return false;

    }

    public boolean checkVertical(String regex) {
        //TODO check for vertical
        return false;
    }

    public boolean checkHorizontal(String regex) {
        //TODO check for horizontal
        return false;
    }

    public boolean checkDiagonals(String regex) {
        //TODO check for diagonal
        return false;
    }

    @Override
    public void getStats() {
        System.out.println(hp[0].getName() + " has " + hp[0].getNumberOfWins() + " wins. \n" +
                hp[1].getName() + " has " + hp[1].getNumberOfWins() + " Wins ");
    }

    public boolean checkStatus(int state) {
        String regex;
        if (state == 1)
            regex = regexPlayer1;
        else
            regex = regexPlayer2;

        if (!checkVertical(regex))
            if (!checkHorizontal(regex))
                return checkDiagonals(regex);

        return true;
    }

    @Override
    public void playGame() {
        String choice;
        System.out.println("Press Enter to start");
        choice = sc.nextLine();
        while (!(choice = sc.next()).equalsIgnoreCase("exit")) {
            int status = initFirstChoice();

            while (checkStatus(status)) {


            }
            System.out.println("Do you want to continue? \nType exit to exit!!!");
        }

    }
}
