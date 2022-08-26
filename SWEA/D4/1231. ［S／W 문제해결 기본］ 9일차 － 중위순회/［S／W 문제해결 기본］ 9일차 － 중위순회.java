import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        String data;
        Node left;
        Node right;
    }

    static class Tree {
        Node root;

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }

        public Node makeNode(String data, Node left, Node right) {
            Node node = new Node();
            node.data = data;
            node.left = left;
            node.right = right;
            return node;
        }

        public void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.data);
                inorder(node.right);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            Tree tree = new Tree();
            int N = Integer.parseInt(br.readLine());
            Node[] node = new Node[N + 1];

            for (int i = 1; i < N + 1; i++) {
                node[i] = new Node();
            }
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String str = st.nextToken();
                int left = 0;
                int right = 0;
                if (st.hasMoreTokens()) {
                    left = Integer.parseInt(st.nextToken());
                    if (st.hasMoreTokens()) {
                        right = Integer.parseInt(st.nextToken());
                    }
                }

                node[num].left = node[left];
                node[num].right = node[right];
                node[num].data = str;
            }


            System.out.print("#" + tc + " ");
            tree.inorder(node[1]);
            System.out.println();
        }
    }
}