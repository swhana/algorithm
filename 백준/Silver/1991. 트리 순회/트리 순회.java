import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Tree tree = new Tree();


        String[][] data = new String[N][3];
        Node[] node = new Node[N];
        for (int i = 0; i < N; i++) {
            data[i][0] = sc.next();
            data[i][1] = sc.next();
            data[i][2] = sc.next();

            Node new_node = tree.createNode(data[i][0]);    //기본 노드 생성
            node[i] = new_node; //노드 배열에 삽입
        }


        for (int i = 0; i < N; i++) {
            //다른 노드들을 탐색해서 데이터가 일치하면 자식노드로 배치
            for (int j = 0; j < N; j++) {
                if (data[i][1].equals(node[j].data)) {
                    node[i].left = node[j];
                }
                if (data[i][2].equals(node[j].data)) {
                    node[i].right = node[j];
                }
            }
        }


        tree.preOrder(node[0]);
        sb.append("\n");
        tree.inOrder(node[0]);
        sb.append("\n");
        tree.postOrder(node[0]);

        System.out.println(sb);


    }

    static class Node {
        String data;
        Node left;  //왼쪽 자식 노드
        Node right; //오른쪽 자식 노드
    }

    static class Tree {
        Node root;

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }

        public Node createNode(String data) {
            Node node = new Node();
            node.data = data;
            return node;
        }


        public void preOrder(Node node) {
            if (node != null) {
                sb.append(node.data);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        public void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                sb.append(node.data);
                inOrder(node.right);
            }
        }

        public void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                sb.append(node.data);
            }
        }
    }
}