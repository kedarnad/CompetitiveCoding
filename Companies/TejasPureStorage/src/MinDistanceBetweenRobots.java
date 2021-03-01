import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinDistanceBetweenRobots {
    public static void main(String[] args) {
        int[] x = {2, 12, 40, 5, 12, 3};
        int[] y = {3, 30, 50, 1, 10, 4};
        int numRobots = 5;
        float ans = minDistance(5, x, y);
        System.out.println(ans);
    }

    public static float minDistance(int numRobots, int[] positionX, int[] positionY) {
        Point[] allPoints = new Point[positionX.length];

        for (int i = 0; i < positionX.length; i++) {
            allPoints[i] = new Point(positionX[i], positionY[i]);
        }

        Arrays.sort(allPoints, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        Point[] sortX = new Point[positionX.length];
        for (int j = 0; j < allPoints.length; j++) {
            sortX[j] = allPoints[j];
        }

        Arrays.sort(allPoints, (o1, o2) -> o1.y - o2.y);

        Point[] sortY = new Point[positionX.length];
        for (int j = 0; j < sortY.length; j++) {
            sortY[j] = allPoints[j];
        }

        float dist = getSmallestDistance(sortX, sortY, 0, sortX.length - 1);

        return dist;
    }

    public static float getSmallestDistance(Point[] sortX, Point[] sortY, int start, int end) {
        float currMinDist = Float.MAX_VALUE;
        if (end - start <= 3) {
            currMinDist = calculateDistance(sortX, start, end);
            return currMinDist;
        }
        int mid = start + (end - start) / 2;
        float minLeftDist = getSmallestDistance(sortX, sortY, start, mid);
        float minRightDist = getSmallestDistance(sortX, sortY, mid + 1, end);
        currMinDist = Math.min(minLeftDist, minRightDist);

        float leftStrip = sortX[mid].x - currMinDist;
        float rightStrip = sortX[mid].x + currMinDist;

        List<Point> stripPoints = new ArrayList<Point>();
        for (int i = 0; i < sortY.length; i++) {
            if (sortY[i].x >= leftStrip && sortY[i].x <= rightStrip) {
                stripPoints.add(sortY[i]);
            }
        }


        List<Point> closestY;
        for (int i = 0; i < stripPoints.size(); i++) {
            closestY = new ArrayList<Point>();
            closestY.add(stripPoints.get(i));
            for (int j = i + 1; j < stripPoints.size(); j++) {
                if (stripPoints.get(j).y - stripPoints.get(i).y <= currMinDist) {
                    closestY.add(stripPoints.get(j));
                }
            }

            Point[] nearOnes = new Point[closestY.size()];
            for (int k = 0; k < nearOnes.length; k++) {
                nearOnes[k] = closestY.get(k);
            }

            currMinDist = Math.min(currMinDist, calculateDistance(nearOnes, 0, nearOnes.length - 1));
        }

        return currMinDist;
    }

    public static float calculateDistance(Point[] sortX, int start, int end) {
        float currMinDist = Float.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                float distance = (float) Math.sqrt((sortX[j].y - sortX[i].y) * (sortX[j].y - sortX[i].y) + (sortX[j].x - sortX[i].x) * (sortX[j].x - sortX[i].x));
                currMinDist = Math.min(distance, currMinDist);
            }
        }
        return currMinDist;
    }

}
