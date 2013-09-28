public class SplitNode extends Node
{
    private Node linkerKind,
            rechterKind;

    public SplitNode(Node ouder) {
        super(ouder);
    }

    public SplitNode setLeft(Node n) {
        linkerKind = n;
        return this;
    }

    public Node getLeft() {
        return linkerKind;
    }

    public SplitNode setRight(Node n) {
        rechterKind = n;
        return this;
    }

    public Node getRight() {
        return rechterKind;
    }


}