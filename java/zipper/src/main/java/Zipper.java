import java.util.Objects;

public class Zipper {

    public Zipper left;
    public Zipper right;
    public Zipper up;
    private int value;

    public Zipper(int value) {
        this.value = value;
    }

    public BinaryTree toTree() {
        Zipper root = this;
        while (Objects.nonNull(root.getUp())) {
            root = root.getUp();
        }
        return new BinaryTree(root);
    }

    public Zipper getLeft() {
        return left;
    }

    public Zipper getRight() {
        return right;
    }

    public Zipper getUp() {
        return up;
    }

    public void setLeft(Zipper left) {
        if (Objects.nonNull(left)) {
            left.setUp(this);
        }
        this.left = left;
    }

    public void setRight(Zipper right) {
        if (Objects.nonNull(right)) {
            right.setUp(this);
        }
        this.right = right;
    }

    public void setUp(Zipper up) {
        this.up = up;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
