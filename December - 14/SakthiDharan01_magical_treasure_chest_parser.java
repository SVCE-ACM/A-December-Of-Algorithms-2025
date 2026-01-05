import java.util.*;

public class SakthiDharan01_magical_treasure_chest_parser {
    private static class Parser {
        String s; int idx;
        Parser(String s){this.s=s; this.idx=0;}
        Object parseVal(){
            if (s.charAt(idx)=='['){
                idx++; // skip [
                List<Object> list = new ArrayList<>();
                while (idx < s.length() && s.charAt(idx) != ']'){
                    list.add(parseVal());
                    if (idx < s.length() && s.charAt(idx)==',') idx++;
                }
                idx++; // skip ]
                return list;
            } else {
                int sign = 1;
                if (s.charAt(idx)=='-'){ sign=-1; idx++; }
                int num=0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))){
                    num = num*10 + (s.charAt(idx)-'0');
                    idx++;
                }
                return sign*num;
            }
        }
    }

    private static String serialize(Object obj){
        if (obj instanceof List){
            List<?> lst = (List<?>) obj;
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < lst.size(); i++){
                if (i>0) sb.append(',');
                sb.append(serialize(lst.get(i)));
            }
            sb.append(']');
            return sb.toString();
        }
        return obj.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) sb.append(sc.nextLine());
        String input = sb.toString().trim();
        if (input.isEmpty()) return;
        if (input.length() >=2 && input.charAt(0)=='"' && input.charAt(input.length()-1)=='"'){
            input = input.substring(1, input.length()-1);
        }
        Parser parser = new Parser(input);
        Object result = parser.parseVal();
        System.out.println(serialize(result));
        sc.close();
    }
}
