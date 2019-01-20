import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    void insert(T value) {
        this.root = insertRecursive(this.root, value);
    }

    List<T> getAsSortedList() {
        List<T> resultList = new ArrayList<>();
        traverseInOrder(resultList, this.root);
        return resultList;
    }

    List<T> getAsLevelOrderList() {
        return traverseLevelOrder();
    }

    Node<T> getRoot() {
        return root;
    }

    private void traverseInOrder(List<T> resultList, Node node) {
        if (node != null) {
            traverseInOrder(resultList, node.leftNode);
            resultList.add((T) node.data);
            traverseInOrder(resultList, node.rightNode);
        }
    }

    private List<T> traverseLevelOrder() {
        List<T> resultList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            resultList.add((T) node.data);
            if (node.leftNode != null) {
                queue.add(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.add(node.rightNode);
            }
        }
        return resultList;
    }

    private Node<T> insertRecursive(Node cur, T value) {
        if (cur == null) {
            return new Node<>(value);
        }
        if (cur.data.compareTo(value) >= 0) {
            cur.leftNode = insertRecursive(cur.leftNode, value);
        } else if (cur.data.compareTo(value) < 0) {
            cur.rightNode = insertRecursive(cur.rightNode, value);
        }
        return cur;
    }

    static class Node<T extends Comparable<T>> {
        private T data;
        private Node leftNode = null;
        private Node rightNode = null;

        public Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return this.leftNode;
        }

        Node<T> getRight() {
            return this.rightNode;
        }

        T getData() {
            return this.data;
        }

    }
}
