import java.util.*;
public class dhanusiyasri_baseball_score_record_keeper {
    public static int calculateScore(String[] operations)
    {
        Stack<Integer> scores=new Stack<>();
        int totalScore=0;
        int n=operations.length;
        for(int i=0;i<n;i++){
            String op=operations[i];
            if(op.matches("-?\\d+"))
                scores.push(Integer.parseInt(op));
            else
            {
                if(op.equals("C")&&!scores.isEmpty())
                {
                    scores.pop();
                }
                else if(op.equals("D")&&!scores.isEmpty()){
                    scores.push(2*scores.peek());
                }
                else if(op.equals("+")&&!scores.isEmpty()){
                    scores.push(scores.get(scores.size()-1)+scores.get(scores.size()-2));
                }
            }
        }
        for(int score:scores)
            totalScore+=score;
        return totalScore;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String[] ops=sc.nextLine().trim().split(",");
        int result=calculateScore(ops);
        System.out.println(result);
        sc.close();
    }
}
//Note:
//Input should be given in a single line with operations separated by commas.
//Example Input: 5,2,C,D,+