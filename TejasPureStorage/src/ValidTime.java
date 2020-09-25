public class ValidTime {


    public static Integer[] solution(Integer[] N, int K) {

        int imax = 0, jmax = 0, i = 0, j = K - 1, sumMax = 0, sumIter = 0;
        Integer result[] = new Integer[K];

        //calculating the initial sum
        for (int l = 0; l < K; l++) {
            sumMax += N[l];
        }

        sumIter = sumMax;

        while (j < N.length - 1) {

            if (j + 1 <= N.length - 1) {
                j++;
                i++;

                sumIter -= N[i - 1];
                sumIter += N[j];

                if (sumIter > sumMax) {
                    sumMax = sumIter;
                    jmax = j;
                    imax = i;
                }

            }

        }
        int il = 0;
        for (int d = imax; d <= jmax; d++) {

            result[il] = N[d];
            il++;
        }
        return result;
    }

    public static void main(String[] args) {


        Integer[] r = solution(new Integer[]{1, 4, 3, 2, 5}, 3);

        for (int i : r) {

            System.out.print(i + " ");
        }

    }
}
