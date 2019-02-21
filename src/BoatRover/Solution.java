package BoatRover;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'roverMove' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER matrixSize
     *  2. STRING_ARRAY cmds
     */

    public static int nextMove(int position, String cmd, int size) {
        if (cmd.equalsIgnoreCase("Right")) {
            if ((position + 1) % size != 0 && !((position + 1) > 12))
                return position + 1;
            else
                return position;
        } else if (cmd.equalsIgnoreCase("left")) {
            if (position % size != 0 && !(position - 1 < 0))
                return position - 1;
            else
                return position;

        } else if (cmd.equalsIgnoreCase("up")) {
            if (!((position - size) < 0))
                return position - size;
            else
                return position;
        } else if (cmd.equalsIgnoreCase("down")) {
            if (!((position + size) > (size * size) - 1)) {
                return position + size;
            } else
                return position;

        }

        return position;
    }

    public static int roverMove(int matrixSize, List<String> cmds) {
        // Write your code here
        // int [][] roverBoard= new int[matrixSize][matrixSize];

        int targetPos = 0;

        int cmdSize = cmds.size();

        if (cmdSize > 0) {
            for (int i = 0; i < cmdSize; i++) {
                targetPos = nextMove(targetPos, cmds.get(i), matrixSize);
            }
        }

        return targetPos;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matrixSize = Integer.parseInt(bufferedReader.readLine().trim());

        int cmdsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> cmds = IntStream.range(0, cmdsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = Result.roverMove(matrixSize, cmds);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
