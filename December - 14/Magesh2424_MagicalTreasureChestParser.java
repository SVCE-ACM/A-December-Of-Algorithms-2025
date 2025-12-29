import java.util.*;

public class Magesh2424_MagicalTreasureChestParser {

    // NestedChest structure
    static class NestedChest {
        Integer value;
        List<NestedChest> list;

        // Constructor for integer treasure
        NestedChest(int value) {
            this.value = value;
            this.list = null;
        }

        // Constructor for compartment
        NestedChest() {
            this.list = new ArrayList<>();
            this.value = null;
        }

        boolean isInteger() {
            return value != null;
        }

        void add(NestedChest nc) {
            list.add(nc);
        }

        // Convert structure to string output
        @Override
        public String toString() {
            if (isInteger()) {
                return String.valueOf(value);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) sb.append(",");
                sb.append(list.get(i).toString());
            }
            sb.append("]");
            return sb.toString();
        }
    }

    // Deserialize function
    static NestedChest deserialize(String s) {
        // Single integer case
        if (!s.startsWith("[")) {
            return new NestedChest(Integer.parseInt(s));
        }

        Stack<NestedChest> stack = new Stack<>();
        NestedChest curr = null;

        int num = 0;
        boolean negative = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedChest();
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
                    curr.add(new NestedChest(num));
                }

                num = 0;
                negative = false;

                if (ch == ']' && !stack.isEmpty()) {
                    NestedChest parent = stack.pop();
                    parent.add(curr);
                    curr = parent;
                }
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read serialized chest string
        String s = sc.nextLine();

        NestedChest result = deserialize(s);

        // Print parsed structure
        System.out.println(result);

        sc.close();
    }
}
