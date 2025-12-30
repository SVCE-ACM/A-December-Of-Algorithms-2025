import java.util.Scanner;
import java.util.Stack;
public class MonishmakerBaseballScoreRecorder {
    public static int baseballScoreRecorder(String[] arr){
        Stack<Integer> stack = new Stack<>();

        for(String op : arr){
            if(op.equals("C")){
                stack.pop();
            }
            else if(op.equals("D")){
                stack.push(2*stack.peek());
            }
            else if(op.equals("+")){
                int last = stack.pop();
                int secondLast = stack.peek();
                int sum = last+secondLast;
                stack.push(last);
                stack.push(sum);
            }
            else{
                stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for(int score : stack){
            total += score;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        String[] ops = new String[n];
        for(int i=0;i<n;i++){
            ops[i] = sc.next();
        }
        System.out.println(baseballScoreRecorder(ops));
    }
} 
