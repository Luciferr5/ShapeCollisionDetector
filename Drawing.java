public class Drawing {
    private AbstractShape shape;
    private static Drawing instance;

    private Drawing() {
        // this.shape = null;
    }

    public AbstractShape getShape() {
        return shape;
    }

    public void setShape(AbstractShape s) {
        shape = s;
    }

    public static Drawing getInstance() {
        if (instance == null) {
            instance = new Drawing();
        }
        return instance;
    }


}
