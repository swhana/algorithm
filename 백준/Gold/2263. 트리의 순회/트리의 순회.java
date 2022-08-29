import java.util.Scanner;

class Tree {
    static int pIndex = 0;  //순회배열의 인덱스
    Node root;

    //중위순회(Inorder), 전위순회(Preorder)로 트리를 구성하는 메소드
    public void buildTreeByInPre(int[] in, int[] pre) {
        pIndex = 0;
        root = buildTreeByInPre(in, pre, 0, in.length - 1);
    }

    private Node buildTreeByInPre(int[] in, int[] pre, int start, int end) {
        if (start > end) return null;
        Node node = new Node(pre[pIndex++]);    //트리의 노드
        if (start == end) return node;
        int mid = search(in, start, end, node.data);
        node.left = buildTreeByInPre(in, pre, start, mid - 1);
        node.right = buildTreeByInPre(in, pre, mid + 1, end);
        return node;
    }

    //중위순회(Inorder), 후위순회(Postorder)로 트리를 구성하는 메소드드
    public void buildTreeByInPost(int[] in, int[] post) {
        pIndex = post.length - 1;
        root = buildTreeByInPost(in, post, 0, in.length - 1);
    }

    private Node buildTreeByInPost(int[] in, int[] post, int start, int end) {
        if (start > end) return null;
        Node node = new Node(post[pIndex--]);
        if (start == end) return node;
        int mid = search(in, start, end, node.data);
        node.right = buildTreeByInPost(in, post, mid + 1, end);
        node.left = buildTreeByInPost(in, post, start, mid - 1);
        return node;
    }

    //value를 가지는 index를 반환하는 함수
    private int search(int[] arr, int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value) return i;
        }
        return i;
    }

    void printPreorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] in = new int[N];
        int[] post = new int[N];

        for (int i = 0; i < N; i++) {
            in[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            post[i] = sc.nextInt();
        }

        Tree tree = new Tree();
        tree.buildTreeByInPost(in, post);
        tree.printPreorder(tree.root);
    }
}