
public class Spel {
    public SpelObject[] objects = new SpelObject[]
            {
            new SpelObject( 900,100),
            new SpelObject( 100,100),
            new SpelObject( 50,750),
            new SpelObject( 110,90),
            new SpelObject( 950,50),
            new SpelObject( 60,800),
            new SpelObject( 40,800),
            new SpelObject( 700,850)
            };


    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.qSort(0);
    }

    public void swap(int i, int j) {
        // Hulp variable
        SpelObject h = objects[i];
        objects[i] = objects[j];
        objects[j] = h;
        System.out.println("SWAP");
    }

    public SpelObject getMediaan(int left, int right, int position) {

        int center = (left+right)/2;

        if(objects[left].getPosition(position) > objects[center].getPosition(position)) swap(center, left);
        if(objects[left].getPosition(position) > objects[right].getPosition(position)) swap(left, right);
        if(objects[center].getPosition(position) > objects[right].getPosition(position)) swap(center, right);

        swap(center, right-1);
        return objects[right-1];
    }

    public void printValues() {
        System.out.println("Actual values: ");
        for(SpelObject o : objects) System.out.print("(" + o.getPosition(0) + ", " + o.getPosition(1) + ") ");
        System.out.println("");
    }

    public void qSort(int position) {
        SplitNode spNode = new SplitNode(null);

        recQuickSort(0, objects.length-1, position,spNode);
    }

    private void recQuickSort(int left, int right, int position, SplitNode spNode) {
        int size = right-left+1;
        int newPos = (position == 0) ? 1 : 0;

        if(size == 1) {
            if(position == 0) spNode.setLeft(new EndNode(spNode, objects[position]));
            else spNode.setRight(new EndNode(spNode, objects[position]));
        }else if(size < 3) {
            if(objects[left].getPosition(position) > objects[right].getPosition(position)) swap(left, right);
            spNode
                    .setLeft(new EndNode(spNode, objects[left]))
                    .setRight(new EndNode(spNode, objects[right]));
            return;
        }else{
            SpelObject median = getMediaan(left, right, position);
            int partition = partition(left, right, median.getPosition(position), position);

            recQuickSort(left, partition, newPos, new SplitNode(spNode).setLeft(new EndNode(spNode, objects[left])));
            recQuickSort(partition+1, right, newPos, new SplitNode(spNode).setRight(new EndNode(spNode, objects[right])));
        }

        printValues();
    }

    private int partition(int left, int right, double pivot, int position) {
        int leftP = left;
        int rightP = right-1;

        while(true) {
            while(objects[++leftP].getPosition(position) < pivot)
                ;
            while(objects[--rightP].getPosition(position) > pivot)
                ;

            if(leftP >= rightP) break;
            else swap(leftP, rightP);
        }
        swap(leftP, right-1);
        return leftP;
    }

}
