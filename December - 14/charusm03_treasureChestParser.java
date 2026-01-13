import java.util.*;

public class charusm03_treasureChestParser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        NestedChest chest = parseChest(s);
        System.out.println(chest);
    }

    static class NestedChest {
        List<Object> items;

        NestedChest() {
            items = new ArrayList<>();
        }

        void add(Object obj) {
            items.add(obj);
        }

        @Override
        public String toString() {
            if (items.isEmpty())
                return "[]";
            if (items.size() == 1 && items.get(0) instanceof Integer)
                return items.get(0).toString();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < items.size(); i++) {
                sb.append(items.get(i).toString());
                if (i != items.size() - 1)
                    sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static NestedChest parseChest(String s) {
        if (s.isEmpty())
            return new NestedChest();

        if (s.charAt(0) != '[') {
            NestedChest single = new NestedChest();
            single.add(Integer.parseInt(s));
            return single;
        }

        Stack<NestedChest> stack = new Stack<>();
        NestedChest current = new NestedChest();
        stack.push(current);

        int numStart = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (i != 0) {
                    NestedChest newChest = new NestedChest();
                    stack.peek().add(newChest);
                    stack.push(newChest);
                }
            } else if (c == ']') {
                if (numStart != -1) {
                    stack.peek().add(Integer.parseInt(s.substring(numStart, i)));
                    numStart = -1;
                }
                stack.pop();
            } else if (c == ',') {
                if (numStart != -1) {
                    stack.peek().add(Integer.parseInt(s.substring(numStart, i)));
                    numStart = -1;
                }
            } else {
                if (numStart == -1)
                    numStart = i;
            }
        }

        return current;
    }
}
