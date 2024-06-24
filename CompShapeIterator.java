public class CompShapeIterator {
    private int cur_Index;
    private CompShape comp_Shape;

    public CompShapeIterator(CompShape shape1) {
        this.comp_Shape = shape1;
        this.cur_Index = 0;
    }

    public void next() {
        cur_Index++;
    }

    public boolean isDone() {
        return cur_Index >= comp_Shape.getComponents().size();
    }

    public void first() {
        cur_Index = 0;
    }

    public AbstractShape getCurrentShape() {
        if (!isDone()) {
            throw new IllegalStateException("Out of bounds");
        }
        return comp_Shape.getComponents().get(cur_Index);
    }


}
