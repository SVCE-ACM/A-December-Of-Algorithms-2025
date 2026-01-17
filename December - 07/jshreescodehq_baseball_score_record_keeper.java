import java.util.ArrayList;

public class BaseballScoreRecordKeeper {

    public static void main(String[] args) {

        String[] ops1 = {"5", "2", "C", "D", "+"};
        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        System.out.println(calPoints(ops1)); 
        System.out.println(calPoints(ops2)); 
    }

    public static int calPoints(String[] operations) {

        ArrayList<Integer> record = new ArrayList<>();

        for (String op : operations) {

            if (op.equals("C")) {
               
                record.remove(record.size() - 1);

            } else if (op.equals("D")) {
              
                int last = record.get(record.size() - 1);
                record.add(last * 2);

            } else if (op.equals("+")) {
               
                int last = record.get(record.size() - 1);
                int secondLast = record.get(record.size() - 2);
                record.add(last + secondLast);

            } else {
 
                record.add(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int score : record) {
            sum += score;
        }

        return sum;
    }
}
