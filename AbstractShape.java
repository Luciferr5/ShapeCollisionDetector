public abstract class AbstractShape {

    private static int numberOfInstances = 0;

    public static int getNumberOfInstances() {
        return numberOfInstances;
    }

    public AbstractShape(){
        numberOfInstances ++;
    }
}

