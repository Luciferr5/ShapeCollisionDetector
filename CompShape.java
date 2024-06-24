import java.util.ArrayList;
// import java.util.List;


public class CompShape extends AbstractShape implements CollisionDetector {
    private ArrayList<AbstractShape> components;

    public CompShape() {
        components = new ArrayList<>();
    }
    public void removeShape(AbstractShape shape1) {
        components.remove(shape1);
    }
    public void addShape(AbstractShape shape1) {
        components.add(shape1);
    }
    public ArrayList<AbstractShape> getComponents() {
        return components;
    }
    public CompShapeIterator getIterator() {
        return new CompShapeIterator(this);
    }

    @Override
    public boolean intersect(Point point1) {
        // Check if any component of CompShape intersects with the point
        for (AbstractShape component : components) {
            if (((CollisionDetector) component).intersect(this) && (component instanceof CollisionDetector)) {
                return true;            }
        }
        return false;
    }

    @Override
    public boolean intersect(Rectangle rectangle1) {
        // Check if any component of CompShape intersects with the rectangle
        for (AbstractShape component : components) {
            if (((CollisionDetector) component).intersect(this) && (component instanceof CollisionDetector)) {
                return true;            }
        }
        return false;
    }

    @Override
    public boolean intersect(LineSeg line1) {
        // Check if any component of CompShape intersects with the line
        for (AbstractShape component : components) {
            if (((CollisionDetector) component).intersect(this) && (component instanceof CollisionDetector)) {
                return true;            }
        }
        return false;
    }

    @Override
    public boolean intersect(CompShape s1) {
       for (AbstractShape component : components) {
        if (((CollisionDetector) component).intersect(this) && (component instanceof CollisionDetector)) {
            return true;            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompShape [");
        for (AbstractShape component : components) {
            sb.append(component.toString()).append(", ");
        }
        if (components.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
        
    }
    
    @Override
    public boolean intersect(Circle circle1) {
        // Check if any component of CompShape intersects with the circle
        for (AbstractShape component : components) {
            if (((CollisionDetector) component).intersect(this) && (component instanceof CollisionDetector)) {
                return true;            }
        }
        return false;
    }

}