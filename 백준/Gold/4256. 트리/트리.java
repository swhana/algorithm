import java.util.Scanner;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int k = 1; k <= tc; k++) {
            int N = sc.nextInt();   //노드의 개수
            int[] pre = new int[N];
            int[] in = new int[N];

            for (int i = 0; i < N; i++)
                pre[i] = sc.nextInt();

            for (int i = 0; i < N; i++)
                in[i] = sc.nextInt();

            Tree1 tree = new Tree1();

            tree.buildTreeByInPre(in, pre);
            tree.printPostorder(tree.root);
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static class Tree1 {

        static int pIndex = 0;      //순회할 배열의 인덱스
        Node root;

        public void buildTreeByInPre(int[] in, int[] pre) {
            pIndex = 0; //맨 앞 인덱스부터 시작
            root = buildTreeByInPre(in, pre, 0, in.length - 1);
        }

        private Node buildTreeByInPre(int[] in, int[] pre, int start, int end) {
            if (start > end) return null;   //start와 end가 교차하면 스탑
            Node node = new Node(pre[pIndex++]);    //전위순회 결과의 인덱스 탐색
            if (start == end) return node;  //노드가 하나인 경우 그대로 반환
            int mid = search(in, start, end, node.data);    //분할정복
            node.left = buildTreeByInPre(in, pre, start, mid - 1);
            node.right = buildTreeByInPre(in, pre, mid + 1, end);
            return node;
        }

        //arr[start]부터 arr[end]에서 value와 일치하는 값을 찾는 메소드
        private int search(int[] arr, int start, int end, int value) {
            int i;
            for (i = start; i <= end; i++)
                if (arr[i] == value) return i;
            return i;
        }

        void printPostorder(Node node) {
            if (node == null) return;
            printPostorder(node.left);
            printPostorder(node.right);
            sb.append(node.data + " ");
        }

        class Node {
            int data;
            Node left, right;

            public Node(int data) {
                this.data = data;
            }
        }
    }
}