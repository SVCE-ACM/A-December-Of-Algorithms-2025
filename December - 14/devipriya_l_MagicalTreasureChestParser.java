import java.util.*;

public class devipriya_l_MagicalTreasureChestParser {
        static class NestedChest {
        Integer value;
        List<NestedChest> list;

        NestedChest(int value) {
            this.value = value;
            this.list = null;
        }

        NestedChest() {
            this.list = new ArrayList<>();
            this.value = null;
        }

        void add(NestedChest nc) {
            list.add(nc);
        }

        @Override
        public String toString() {
            if (value != null) {
                return value.toString();
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

    public static NestedChest parse(String s) {
        if (s.charAt(0) != '[') {
            return new NestedChest(Integer.parseInt(s));
        }

        Stack<NestedChest> stack = new Stack<>();
        NestedChest current = null;
        int num = 0;
        boolean negative = false;
        boolean hasNumber = false;

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                if (current != null) {
                    stack.push(current);
                }
                current = new NestedChest();
            }
            else if (ch == ']') {
                if (hasNumber) {
                    current.add(new NestedChest(negative ? -num : num));
                }
                if (!stack.isEmpty()) {
                    NestedChest parent = stack.pop();
                    parent.add(current);
                    current = parent;
                }
                num = 0;
                negative = false;
                hasNumber = false;
            }
            else if (ch == ',') {
                if (hasNumber) {
                    current.add(new NestedChest(negative ? -num : num));
                    num = 0;
                    negative = false;
                    hasNumber = false;
                }
            }
            else if (ch == '-') {
                negative = true;
            }
            else { 
                num = num * 10 + (ch - '0');
                hasNumber = true;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        NestedChest result = parse(s);
        System.out.println(result);
        sc.close();
    }
}
