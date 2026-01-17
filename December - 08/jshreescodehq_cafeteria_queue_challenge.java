public class CafeteriaQueueChallenge {

    public static void main(String[] args) {

        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};

        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};

        System.out.println(countStudents(students1, sandwiches1)); 
        System.out.println(countStudents(students2, sandwiches2)); 
    }

    public static int countStudents(int[] students, int[] sandwiches) {

        int count0 = 0, count1 = 0;

        for (int s : students) {                                       // student preferences
            if (s == 0) count0++;
            else count1++;
        }

        for (int s : sandwiches) {                                     // Process sandwiches 
                         
            if (s == 0) {
                if (count0 > 0) count0--;
                else break;
            } else {
                if (count1 > 0) count1--;
                else break;
            }
        }
        return count0 + count1;
    }
}
