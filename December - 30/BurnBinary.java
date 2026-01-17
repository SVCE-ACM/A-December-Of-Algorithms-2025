package Dec30;
import java.util.*;
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }


    public class BurnBinary {

        // Build tree from level order input
        static Node buildTree(List<Integer> values) {
            if (values.size() == 0 || values.get(0) == -1) return null;

            Node root = new Node(values.get(0));
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            int i = 1;
            while (!q.isEmpty() && i < values.size()) {
                Node curr = q.poll();

                if (values.get(i) != -1) {
                    curr.left = new Node(values.get(i));
                    q.add(curr.left);
                }
                i++;

                if (i < values.size() && values.get(i) != -1) {
                    curr.right = new Node(values.get(i));
                    q.add(curr.right);
                }
                i++;
            }
            return root;
        }

        // Map child -> parent
        static void mapParents(Node root, Map<Node, Node> parentMap) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.poll();

                if (curr.left != null) {
                    parentMap.put(curr.left, curr);
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    parentMap.put(curr.right, curr);
                    q.add(curr.right);
                }
            }
        }

        // Find target node
        static Node findTarget(Node root, int target) {
            if (root == null) return null;
            if (root.data == target) return root;

            Node left = findTarget(root.left, target);
            if (left != null) return left;

            return findTarget(root.right, target);
        }

        // Burning process
        static void burnTree(Node root, int target) {
            Map<Node, Node> parentMap = new HashMap<>();
            mapParents(root, parentMap);

            Node targetNode = findTarget(root, target);
            if (targetNode == null) {
                System.out.println("Target not found");
                return;
            }

            Queue<Node> q = new LinkedList<>();
            Set<Node> visited = new HashSet<>();

            q.add(targetNode);
            visited.add(targetNode);

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    System.out.print(curr.data + " ");

                    if (curr.left != null && !visited.contains(curr.left)) {
                        visited.add(curr.left);
                        q.add(curr.left);
                    }

                    if (curr.right != null && !visited.contains(curr.right)) {
                        visited.add(curr.right);
                        q.add(curr.right);
                    }

                    if (parentMap.containsKey(curr)) {
                        Node parent = parentMap.get(curr);
                        if (!visited.contains(parent)) {
                            visited.add(parent);
                            q.add(parent);
                        }
                    }
                }
                System.out.println(); // next time step
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                values.add(sc.nextInt());
            }
            int target = sc.nextInt();
            Node root = buildTree(values);
            burnTree(root, target);
        }
    }


