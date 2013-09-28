public class EndNode extends Node
{
    private SpelObject spelObject;
    public EndNode( Node ouder, SpelObject spelObject )
    {
        super( ouder );
        this.spelObject = spelObject;
    }

    public SpelObject getSpel() {
        return spelObject;
    }
}