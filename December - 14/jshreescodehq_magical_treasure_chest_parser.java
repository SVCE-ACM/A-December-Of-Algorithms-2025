import java.util.*;

public class MagicalTreasureChestParser {
    static class NestedChest {
        Integer value;                 // single treasure
        List<NestedChest> list;        // compartment

        NestedChest() {
            list = new ArrayList<>();
        }

        NestedChest(int value) {
            this.value = value;
        }

        boolean isInteger() {
            return value != null;
        }

        void add(NestedChest ni) {
            list.add(ni);
        }

        @Override
        public String toString() {
            if (isInteger()) {
                return value.toString();
            }
            return list.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        NestedChest result = parseChest(s);
        System.out.println(result);

        sc.close();
    }

    static NestedChest parseChest(String s) {

        // Case: single number
        if (s.charAt(0) != '[') {
            return new NestedChest(Integer.parseInt(s));
        }

        Stack<NestedChest> stack = new Stack<>();
        NestedChest current = null;
        int num = 0;
        boolean negative = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                NestedChest nc = new NestedChest();
                if (!stack.isEmpty()) {
                    stack.peek().add(nc);
                }
                stack.push(nc);
            } 
            else if (ch == '-') {
                negative = true;
            } 
            else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            else if (ch == ',' || ch == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (negative) num = -num;
                    stack.peek().add(new NestedChest(num));
                }
                num = 0;
                negative = false;

                if (ch == ']') {
                    current = stack.pop();
                }
            }
        }
        return current;
    }
}
