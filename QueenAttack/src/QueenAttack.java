public class QueenAttack {

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
    boolean isReached = false;

//    public boolean isAttack(int firstPosR, int firstPosC, int attackPosR, int attackPosC){
//        if(firstPosR==attackPosR && firstPosC==attackPosC)
//            return true;
//
//
//        if(firstPosR<0 || firstPosR>=8 || firstPosC<0 || firstPosC>=8)
//            return false;
//
//        for(int[] dir:dirs){
//            int nr=dir[0]+firstPosR;
//            int nc=dir[1]+firstPosC;
//
//            if(nr>=0 && nc<8 && nc>=0 && nr<8)
//                isReached=isReached||isAttack(nr, nc, attackPosR, attackPosC);
//
//        }
//        return isReached;
//    }

    public static void main(String[] args) {
        QueenAttack qa = new QueenAttack();
        qa.checkAttck();
    }

    public boolean isAttack(int qR, int qC, int oR, int oC) {
        if (qR == oR)
            return true;

        // If queen and the opponent
        // are in the same column
        if (qC == oC)
            return true;

        // If queen can attack diagonally
        return Math.abs(qR - oR) == Math.abs(qC - oC);

        // Opponent is safe
    }

    public void checkAttck() {

        System.out.println(isAttack(4, 5, 8, 8));

    }
}
