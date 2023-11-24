package advanced.module5.dsa50_oct06;

public class PainterPartitionProblem {
    public static void main(String[] args) {
        int noOfPainters = new PainterPartitionProblem().findNoOfPainters(new int[]{2, 4, 9, 23, 12}, 46, 2);
        noOfPainters = new PainterPartitionProblem().findNoOfPainters(new int[]{2, 4, 9, 23, 12}, 69, 3);
        System.out.println("noOfPainters = " + noOfPainters);
    }

    private int findNoOfPainters(int[] plankLengths, int timeAllocated, int timePerLength) {
        int painterCount = 1, timeLeft = timeAllocated;
        int N = plankLengths.length;
        for (int i = 0; i < N; i++) {
            //Time to paint the ith plank
            int timeToPaintPlank = plankLengths[i] * timePerLength;
            //No timeLeft to paint the plank
            if (timeToPaintPlank > timeAllocated) return -1;
            if (timeToPaintPlank <= timeLeft) {
                timeLeft = timeLeft - timeToPaintPlank;
            } else {
                painterCount++;
                //The new painter has timeAllocated units of timeLeft
                timeLeft = timeAllocated;
                //When he does the new job, left with timeLeft - timeToPaintPlank units of timeLeft
                timeLeft = timeLeft - timeToPaintPlank;
            }
        }
        return painterCount;
    }
}
