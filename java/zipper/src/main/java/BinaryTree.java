import java.util.Objects;

public class BinaryTree {

    private Zipper root;

    public BinaryTree(Zipper zipper) {
        this.root = zipper;
    }

    public BinaryTree(int value) {
        this.root = new Zipper(value);
    }

    public Zipper getRoot() {
        return this.root;
    }

    public String printTree() {
        return print(this.root);
    }

    private String print(Zipper zipper) {
        if (Objects.isNull(zipper)) {
            return "null";
        }
        return String.format("value: %d, left: %s, right: %s", zipper.getValue(), wrap(print(zipper.getLeft())),
                             wrap(print(zipper.getRight())));
    }

    private String wrap(String s) {
        return s.equals("null") ? s : ("{ " + s + " }");
    }

    @Override
    public boolean equals(Object obj) {
        BinaryTree other = (BinaryTree) obj;
        return this.root.equals(other.getRoot());
    }
}
