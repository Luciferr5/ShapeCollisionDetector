public class LineSeg extends AbstractShape implements CollisionDetector {

    private Point begin;
    private Point end;
    private static int numberOfInstances;

    LineSeg() throws ShapeArgumentException {
        throw new ShapeArgumentException("LineSeg");
    }

    LineSeg(Point begin, Point end) {
        try {
            if ((begin.getX() == end.getX()) && (begin.getY() == end.getY())) {
                throw new ShapeArgumentException("LineSeg");
            }
            this.begin = begin;
            this.end = end;
            LineSeg.numberOfInstances += 1;

        } catch (ShapeArgumentException error) {
            System.out.println("ShapeArgumentException error: LineSeg");
        }
    }

    public Point getbegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public static int getNumberOfInstances() {
        return numberOfInstances;
    }

    public boolean intersect(Point s) {
        Float m = ( (end.getY() - begin.getY() ) / (end.getX() - begin.getX()) );
        Float b = end.getY() - (m * end.getX()) ;

        if ( (end.getX() - begin.getX()) == 0)
            if( Math.abs(end.getX() - s.getX()) <= Math.pow(10, (-5)))
                if( (end.getY() >= s.getX()) && (begin.getY() <= s.getX()) || ( (end.getY() <= s.getX()) && (begin.getY() >= s.getX())))
                    return true;
        
        if ( ( (s.getX()*m) + b ) == s.getY() )
            return true;
        return false;

    }

    public boolean intersect(LineSeg s) {
        Point L = new Point(s.getbegin().getX(), s.getbegin().getY());          
        Point M = new Point(s.getEnd().getX(), s.getEnd().getY());              
        Point N = new Point(begin.getX(), begin.getY());                        
        Point O = new Point(end.getX(), end.getY());                            
        Float a = L.getX();
        Float b = M.getX();
        Float c = N.getX();
        Float d = O.getX();
        // Point LM = new Point( (b-a) , (M.getY()-L.getY()) );
        // Point NO = new Point( (d-c) , (O.getY()-N.getY()) );
        double denominator = ( ((b - a) * (O.getY()-N.getY())) - ((b - a) * (O.getY()-N.getY()))); 
        double Alpha = ( ((b - a) * (L.getY()-N.getY())) - ((b - a) * (L.getY()-N.getY()))); 
        double Beta = ( ((d - c) * (L.getY()-N.getY())) - ((d - c) * (L.getY()-N.getY())));
        

        if ( ( (Beta/denominator > 0)  && (Beta/denominator < 1) ) && ( (Alpha/denominator > 0 ) && (Alpha/denominator < 1)  ) )
            return true;
        
        if (denominator == 0)
            return false;

        if ( Alpha == 0 && denominator == 0)
            if( ( (c >= a) && (c <= b) || ( (d >= a) && (d <= b) ) || ( (a >= c) && (a <= d) || ( (b >= c) && ( ( b <= d)) ) ) ) )
                return true;
        return false; 
    }

    public boolean intersect(Rectangle s) {
        Point point1 = new Point(s.getleft(), s.getdown()); 
        Point point2 = new Point(s.getright(), s.getdown());
        Point point3 = new Point(s.getleft(), s.gettop());
        Point point4 = new Point(s.getright(), s.gettop());
        Point point5 = new Point(s.getdown(), s.getleft());
        Point point6 = new Point(s.gettop(), s.getleft());
        Point point7 = new Point(s.getdown(), s.getright());
        Point point8 = new Point(s.gettop(), s.getright());
        LineSeg line1 = new LineSeg(point1, point2);
        LineSeg line2 = new LineSeg(point3, point4);
        LineSeg line3 = new LineSeg(point5, point6);
        LineSeg line4 = new LineSeg(point7, point8);

        if (intersect(line1) || intersect(line2) || intersect(line3) || intersect(line4) )
            return true;
        return false;
    }

    public boolean intersect(Circle s) {
        float EX = end.getX();
        float BX = begin.getX();
        float BY = begin.getY();
        float SX = s.getCenter().getX();
        float SY = s.getCenter().getY();
        float SR = s.getRadius();
        float reciSlope = -1 / ((EX) - (BY))/((EX) - (BX));
        float dist = SY - (reciSlope * SX);

        float edgeX = SX + SR;
        float edgeY = (reciSlope * edgeX) + dist;
        Point newP1 = new Point(SX,SY);
        Point newP2 = new Point(edgeX,edgeY);
        LineSeg newLS = new LineSeg(newP1, newP2);
        return (intersect(newLS) || begin.intersect(s) || end.intersect(s));

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


