public class Rectangle extends AbstractShape implements CollisionDetector {
    private float left;
    private float right;
    private float top;
    private float down;
    private static int numberOfInstances;

    Rectangle() throws ShapeArgumentException {
        throw new ShapeArgumentException("Rectangle");
    }

    Rectangle(float l, float r, float t, float b) {
        try {
            if ((l > r) || (b < t)) {
                throw new ShapeArgumentException("Rectangle");
            }
            this.down = b;
            this.right = r;
            this.top = t;
            this.left = l;

            Rectangle.numberOfInstances += 1;

        } catch (ShapeArgumentException e) {
            System.out.println("ShapeArgumentException error: rectangle");
        }
    }

    public float getleft() {
        return left;
    }

    public float getright() {
        return right;
    }

    public float gettop() {
        return top;
    }

    public float getdown() {
        return down;
    }

    public static int getNumberOfInstances() {
        return numberOfInstances;
    }

    public boolean intersect(Point s) {
        Rectangle newRect = new Rectangle(left, right, top, down);
        return s.intersect(newRect);
    }

    public boolean intersect(LineSeg s) {
        Rectangle newRect = new Rectangle(left, right, top, down);
        return s.intersect(newRect);
    }

    public boolean intersect(Rectangle s) {
        Rectangle newRectangle = new Rectangle(left, right, top, down);
        if ((newRectangle.left > s.right) || (newRectangle.right < s.left) || (newRectangle.top < s.down) || (newRectangle.down > s.top) )
            return true;
        return false;
    }

    public boolean intersect(Circle s) {
        Rectangle newRect = new Rectangle(left, right, top, down);
        Point circCenter = s.getCenter();
        Point topRight = new Point(right, top);
        Point topLeft = new Point(left, top);
        Point bottomRight = new Point(right, down);
        Point bottomLeft = new Point(left, down);
        LineSeg bottomLine = new LineSeg(bottomRight, topRight);
        LineSeg topLine = new LineSeg(topRight, topLeft);
        LineSeg leftLine = new LineSeg(topLeft, bottomLeft);
        LineSeg rightLine = new LineSeg(bottomRight, topRight);

        if (circCenter.intersect(newRect)){
            return true;
        }
        else if( topRight.intersect(s) || topLeft.intersect(s) || bottomRight.intersect(s) || bottomLeft.intersect(s) || bottomLine.intersect(s) || topLine.intersect(s) || rightLine.intersect(s) || leftLine.intersect(s) ) {
            return true;
        }
        else if(circCenter.intersect(bottomLine) || circCenter.intersect(topLine) || circCenter.intersect(leftLine) || circCenter.intersect(rightLine)){
            return true;
        }
        return false;

    }

    public boolean intersect(CompShape s) {
        for (AbstractShape component : s.getComponents()) {
             if (((CollisionDetector) component).intersect(this) && (component instanceof CollisionDetector)) {
                 return true;
             }
         }
         return false;
     }

}

