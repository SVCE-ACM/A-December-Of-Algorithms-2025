package Dec07;
import java.util.*;
public class BaseballScore {
    public static void main(String args[]){

    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    Stack<Integer>stack=new Stack<>();
    for(int i=0;i<n;i++){
        String k=s.next();
        if(k.equals("C")){
            stack.pop();
        }
        else if(k.equals("D")){
            stack.push(2*stack.peek());
        }
        else if(k.equals("+")){
            int last=stack.pop();
            int prevlast=stack.peek();
            stack.push(last);
            stack.push(last+prevlast);
        }
        else {
            stack.push(Integer.parseInt(k));
        }
    }
    int sum=0;
    for(int i:stack){
        sum+=i;
    }
        System.out.println(sum);
    }
}

