package Dec14;
import java.util.*;
    class NestedChest {
        Integer value;
        List<NestedChest> list;

        // Constructor for integer
        NestedChest(int val) {
            value = val;
            list = null;
        }

        // Constructor for list
        NestedChest() {
            value = null;
            list = new ArrayList<>();
        }

        boolean isInteger() {
            return value != null;
        }

        void add(NestedChest nc) {
            list.add(nc);
        }

        @Override
        public String toString() {
            if (isInteger()) {
                return String.valueOf(value);
            }
            return list.toString();
        }
    }

    public class magicalTreasureChestParser {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            NestedChest result = parse(s);
            System.out.println(result);
        }

        static NestedChest parse(String s) {
            // Case: only a number
            if (s.charAt(0) != '[') {
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
                else if (ch == ']') {
                    if (Character.isDigit(s.charAt(i - 1))) {
                        curr.add(new NestedChest(negative ? -num : num));
                    }
                    num = 0;
                    negative = false;

                    if (!stack.isEmpty()) {
                        NestedChest parent = stack.pop();
                        parent.add(curr);
                        curr = parent;
                    }
                }
                else if (ch == ',') {
                    if (Character.isDigit(s.charAt(i - 1))) {
                        curr.add(new NestedChest(negative ? -num : num));
                        num = 0;
                        negative = false;
                    }
                }
                else if (ch == '-') {
                    negative = true;
                }
                else { // digit
                    num = num * 10 + (ch - '0');
                }
            }
            return curr;
        }
    }


