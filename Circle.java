public class Circle extends AbstractShape implements CollisionDetector {
    private Point center;
    private float radius;
    private static int numberOfInstances;


    Circle() throws ShapeArgumentException {
        throw new ShapeArgumentException("Circle");
    }

    Circle(Point center, float radius) {
        try {
            if (radius <= 0) {
                throw new ShapeArgumentException("Circle");
            }
            this.center = center;
            this.radius = radius;
            Circle.numberOfInstances += 1;

        } catch(ShapeArgumentException e) {
            System.out.println("ShapeArgumentException error: circle" );
        }
    }

    public Point getCenter() {
        return center;
    }

    public float getRadius() {
        return radius;
    }

    public static int getNumberOfInstances() {
        return numberOfInstances;
    }

    public boolean intersect(Point s) {
        Circle newCircle = new Circle(center, radius);
        return s.intersect(newCircle);
    }


    public boolean intersect(LineSeg s) {
        Circle newCirc = new Circle(center, radius);
        return s.intersect(newCirc);
    }

    public boolean intersect(Rectangle s) {
        Circle newCircle = new Circle(center, radius);
        return s.intersect(newCircle);
    }

    public boolean intersect(Circle s) {
        Float centX = s.getCenter().getX();
        Float centY = s.getCenter().getY();
        double distance = Math.sqrt(Math.pow(centX - center.getX(), 2) + Math.pow(centY - center.getY(), 2));
        if (distance < (this.radius + s.getRadius()))
            return true;
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


