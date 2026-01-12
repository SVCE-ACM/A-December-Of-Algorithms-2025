// Definition for NestedChest (same as NestedInteger)
class NestedChest {
    private Integer value;
    private List<NestedChest> list;

    public NestedChest() {
        list = new ArrayList<>();
    }

    public NestedChest(int value) {
        this.value = value;
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public void add(NestedChest ni) {
        list.add(ni);
    }

    public List<NestedChest> getList() {
        return list;
    }
}

class Solution {
    public NestedChest deserialize(String s) {
        // Case 1: single integer
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
            } else if (ch == '-') {
                negative = true;
            } else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == ',' || ch == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    curr.add(new NestedChest(negative ? -num : num));
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
}
