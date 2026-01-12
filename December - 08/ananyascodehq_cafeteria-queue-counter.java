class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;

        // Count preferences
        int count0 = 0, count1 = 0;
        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }

        // Walk through sandwiches
        int i = 0;
        while (i < n) {
            if (sandwiches[i] == 0) {
                if (count0 > 0) {
                    count0--;
                } else {
                    break; // nobody wants a 0
                }
            } else { // sandwich == 1
                if (count1 > 0) {
                    count1--;
                } else {
                    break; // nobody wants a 1
                }
            }
            i++;
        }

        // Remaining sandwiches == remaining students
        return n - i;
    }
}
