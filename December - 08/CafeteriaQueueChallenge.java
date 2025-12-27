public class CafeteriaQueueChallenge {

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        int count0 = 0, count1 = 0;

        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }

        for (int sw : sandwiches) {
            if (sw == 0) {
                if (count0 > 0) count0--;
                else break;
            } else {
                if (count1 > 0) count1--;
                else break;
            }
        }
        int unableToEat = count0 + count1;
        System.out.println(unableToEat);
    }
}
