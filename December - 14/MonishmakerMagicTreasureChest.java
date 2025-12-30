import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class NestedChest{
    Integer treasure;
    List<NestedChest> compartment;
//Constructor for a single treasure
    public NestedChest(int value){
        this.treasure = value;
        this.compartment = null;
    }
//Constructor for a compartment
    public NestedChest(){
        this.treasure = null;
        this.compartment = new ArrayList<>();
    }
    @Override
    public String toString(){
        if(treasure != null){
            return treasure.toString();
        }else{
            return compartment.toString();
        }
    }
}
public class MonishmakerMagicTreasureChest {
    public static NestedChest parse(String s){
        if(s.charAt(0) != '['){
            return new NestedChest(Integer.parseInt(s));
        }

        Stack<NestedChest> stack = new Stack<>();
        NestedChest current = null;
        int num = 0;
        boolean negative = false;
        boolean hasNumber = false;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='['){
                NestedChest nc = new NestedChest();
                if(!stack.isEmpty()){
                    stack.peek().compartment.add(nc);
                }
                stack.push(nc);
            }else if(c==']'){
                if(hasNumber){
                    int value = negative ? -num : num;
                    stack.peek().compartment.add(new NestedChest(value));
                    num = 0;
                    negative = false;
                    hasNumber = false;
                }
                current = stack.pop();
            }else if(c==','){
                    if(hasNumber){
                        int value = negative ? -num:num;
                        stack.peek().compartment.add(new NestedChest(value));
                        num = 0;
                        negative = false;
                        hasNumber = false;
                    }
            }else if(c=='-'){
                        negative = true;
            }else if(Character.isDigit(c)){
                        num = num*10 + (c-'0');
                        hasNumber = true;
            }

        }
        return current;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(parse(s));
       }

}
