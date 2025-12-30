import java.util.*;

public class Day14_MagicalTreasureChestParser {
    public static Object parse(String s){
        if (!s.startsWith("[")) return Integer.parseInt(s);
        Deque<Object> stack = new ArrayDeque<>();
        Deque<List<Object>> lists = new ArrayDeque<>();
        List<Object> cur = new ArrayList<>();
        String num = "";
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='['){ lists.push(cur); cur=new ArrayList<>(); }
            else if (c==']'){ if (!num.isEmpty()){ cur.add(Integer.parseInt(num)); num="";} List<Object> finished=cur; cur=lists.pop(); cur.add(finished); }
            else if (c==','){ if (!num.isEmpty()){ cur.add(Integer.parseInt(num)); num="";} }
            else if (c=='-'||Character.isDigit(c)){ num+=c; }
        }
        return cur.get(0);
    }

    public static void printObj(Object o){
        if (o instanceof Integer) { System.out.println(o); return; }
        System.out.println(toString(o));
    }

    public static String toString(Object o){
        if (o instanceof Integer) return o.toString();
        List<?> l = (List<?>) o; StringJoiner sj = new StringJoiner(",", "[", "]");
        for(Object e: l) sj.add(toString(e)); return sj.toString();
    }

    public static void main(String[] args){ Scanner sc = new Scanner(System.in); String s = sc.nextLine().trim(); if (s.isEmpty()) {System.out.println(); return;} Object res = parse(s); printObj(res); sc.close(); }
}
