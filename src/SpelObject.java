
public class SpelObject
{
    public static final int DIMENSION = 2;
    private double[] position = new double[DIMENSION];

    public SpelObject(double x, double y){
        position = new double[]{x,y};
    }

    // nog in te vullen
    public double getPosition( int index )
    {
        return position[index];
    }
}
