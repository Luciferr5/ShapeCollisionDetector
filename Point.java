public class Point extends AbstractShape implements CollisionDetector{

    private float x = 0;
    private float y = 0;
    private static int numberOfInstances;

    public Point(){
        Point.numberOfInstances++;
    }

    public Point(float x, float y){
        this.x = x;
        this.y = y;
        Point.numberOfInstances++;
    }

    public float getX (){
        return x;
    }

    public float getY (){
        return y;
    }

    public static int getNumberOfInstances(){
        return numberOfInstances;
    }

    public boolean intersect(Point s){
        if (x == s.getX() && y == s.getY())
            return true;
        return false; 
    }

    public boolean intersect(LineSeg s) {
        Point newPoint = new Point(x, y);
           return s.intersect(newPoint);
        }    

    public boolean intersect(Rectangle s) {
        if (x >= s.getleft() && x <= s.getright() && y >= s.getdown() && y <= s.gettop()) 
            return true;
        return false;
    }

    public boolean intersect(Circle s){
        double distance = this.distTo(s.getCenter());

        if (distance <= s.getRadius()) {
            return true;
        } else {
            return false;
        }    }

    //Helper function
    public double distTo(Point p) {
        return Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
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


    
