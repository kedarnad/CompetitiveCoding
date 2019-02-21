package connectFour;

public class ConnectFourDriver {
    public static void main(String[] args) {
        ConnectFourPlayerInterface player1 = new HumanPlayer("Neel");
        ConnectFourPlayerInterface player2 = new HumanPlayer("Kedoo");
        ConnectFourGameInterface game = new ConnectFourGame(player1, player2);
        game.playGame();
        game.getStats();
    }
}
