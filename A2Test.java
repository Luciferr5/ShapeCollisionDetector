import static org.junit.Assert.*;
// import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class A2Test {


//CIRCLE TEST CASES

    //CIRCLE INTERSECTS RECTANGLE
    @Test
	public void testCircleIntersectRectangle() {
            // Case 1 Not Intersecting
            Rectangle r1 = new Rectangle(0, 4, 4, 0);
            Circle c1 = new Circle(new Point(8, 3), 3);
            assertFalse(r1.intersect(c1));	

            // Case 2 Intersecting
            Circle c2 = new Circle(new Point(2, 2), 3);
            assertTrue(r1.intersect(c2));	

            // Case 3 Circle and rectangle are just touching
            Circle c3 = new Circle(new Point(7, 3), 3);
            assertFalse(r1.intersect(c3));	
        }

    //CIRCLE INTERSECTS POINT 
	@Test
	public void testCircleIntersectPoint() {
            // Case 1 Not Intersecting
            Point p1 = new Point(5, 3);
            Circle c1 = new Circle(new Point(0, 0), 5);
            assertFalse(c1.intersect(p1));	

            // Case 2 Intersecting
            Point p2 = new Point(3, 3);
            assertTrue(c1.intersect(p2));	

            //Case 3 Point and circle are just touching
            Point p3 = new Point(5, 0);
            assertTrue(c1.intersect(p3));
        }

    //CIRCLE INTERSECTS LINE SEG
	@Test
	public void testCircleIntersectLineSeg() {
            // Case 1 Not Intersecting
            LineSeg p1 = new LineSeg(new Point(0, 6), new Point(5, 11));
            Circle c1 = new Circle(new Point(0, 0), 5);
            assertFalse(c1.intersect(p1));	
        
            // Case 2 Intersecting
            LineSeg l2 = new LineSeg(new Point(1, 1), new Point(3, 3));
            assertTrue(c1.intersect(l2));	
        
            //Case 3 Circle and line seg are just touching
            LineSeg l3 = new LineSeg(new Point(0, 5), new Point(5, 10));
            assertTrue(c1.intersect(l3));
        }
        
    //CIRCLE INTERSECTS CIRCLE 
	@Test
	public void testCircleIntersectCircle() {
            // Case 1 Not Intersecting
            Circle c2 = new Circle(new Point(4, 0), 3);
            Circle c1 = new Circle(new Point(-4, 0), 3);
            assertFalse(c1.intersect(c2));	

            // Case 2 Intersecting
            Circle c3 = new Circle(new Point(1, 0), 3);
            assertTrue(c2.intersect(c3));	

            //Case 3 Circle and circle are just touching
            Circle c4 = new Circle(new Point(-2, 0), 3);
            assertFalse(c2.intersect(c4));
        	}

//RECTANGLE TEST CASES 

    //RECTANGLE INTERSECTS RECTANGLE  
	@Test
	public void testRectangleIntersectRectangle() {
            // Case 1 Not Intersecting
            Rectangle r1 = new Rectangle(0, 10, 10, 0);
            Rectangle r2 = new Rectangle(20, 30, 30, 20);
            assertTrue(r1.intersect(r2));	

            // Case 2 Intersecting
            Rectangle r5 = new Rectangle(0, 4, 4, 0);
            Rectangle r3 = new Rectangle(1, 3, 3, 1);
            assertFalse(r5.intersect(r3));	

            // Case 3 Rectangle and rectangle are just touching
            Rectangle r4 = new Rectangle(4, 8, 4, 0);
            assertFalse(r5.intersect(r4));	
	}

    //RECTANGLE INTERSECTS CIRCLE 
	@Test
	public void testRectangleIntersectCircle() {
            // Case 1 Not Intersecting
            Rectangle r1 = new Rectangle(2, 3, 3, 1);
            Rectangle r2 = new Rectangle(2, 3, 3, 1);
            assertFalse(r1.intersect(r2));	

            // Case 2 Intersecting
            Rectangle r3 = new Rectangle(1, 3, 3, 1);
            assertFalse(r1.intersect(r3));	

            // Case 3 Rectangle and circle are just touching
            Rectangle r4 = new Rectangle(3, 3, 3, 1);
            assertFalse(r1.intersect(r4));	
	}
    
    //RECTANGLE INTERSECTS POINT 
	@Test
	public void testRectangleIntersectPoint() {
            // Case 1 Not Intersecting
            Rectangle r1 = new Rectangle(0, 4, 4, 0);
            Point p1 = new Point(5, 5);
            assertFalse(r1.intersect(p1));	

            // Case 2 Intersecting
            Point p2 = new Point(1, 1);
            assertTrue(r1.intersect(p2));	

            // Case 3 Rectangle and point are just touching
            Point p3 = new Point(4, 4);
            assertTrue(r1.intersect(p3));	
	}

    //RECTANGLE INTERSECTS LINE SEG 
	@Test
	public void testRectangleIntersectLineSeg() {
            // Case 1 Not Intersecting
            Rectangle r1 = new Rectangle(0, 4, 4, 0);
            LineSeg l1 = new LineSeg(new Point(5, 5), new Point(7, 7));
            assertFalse(r1.intersect(l1));	

            // Case 2 Intersecting 
            LineSeg l2 = new LineSeg(new Point(0, 0), new Point(3, 3));
            assertFalse(r1.intersect(l2));	

            // Case 3 Rectangle and line seg are just touching
            LineSeg l4 = new LineSeg(new Point(4, 4), new Point(6, 6));
            assertFalse(r1.intersect(l4));	
	}

//LINE SEG TEST CASES 

    //LINE SEG INTERSECTS RECTANGLE  
	@Test
	public void testLineSegIntersectRectangle() {
            // Case 1 Not Intersecting
            Rectangle r1 = new Rectangle(2, 3, 3, 4);
            LineSeg l1 = new LineSeg(new Point(2, 3), new Point(2, 3));
            assertFalse(l1.intersect(r1));	

            // Case 2 Intersecting
            Rectangle r2 = new Rectangle(2, 3, 3, 4);
            assertFalse(l1.intersect(r2));	

            // Case 3 Line seg and rectangle are just touching
            Rectangle r3 = new Rectangle(2, 3, 3, 4);
            assertFalse(l1.intersect(r3));		
	}

    //LINE SEG INTERSECTS CIRCLE   
	@Test
	public void testLineSegIntersectCircle() {
            // Case 1 Not Intersecting
            LineSeg l1 = new LineSeg(new Point(0, 6), new Point(5, 11));
            Circle c1 = new Circle(new Point(0, 0), 5);
            assertFalse(l1.intersect(c1));	
        
            // Case 2 Intersecting
            Circle c2 = new Circle(new Point(5, 5), 1);
            assertFalse(l1.intersect(c2));	
        
            //Case 3 Line Seg and circle are just touching
            Circle c3 = new Circle(new Point(5, 5), 1);
            assertFalse(l1.intersect(c3));
        }
    
    //LINE SEG INTERSECTS POINT 
	@Test
	public void testLineSegIntersectPoint() {
            // Case 1 Not Intersecting
            LineSeg l1 = new LineSeg(new Point(0, 0), new Point(6, 6));
            Point p1 = new Point(4, 3);
            assertFalse(l1.intersect(p1));	

            // Case 2 Intersecting
            Point p2 = new Point(3, 3);
            assertTrue(l1.intersect(p2));	
	}

    //LINE SEG INTERSECTS LINE SEG 
	@Test
	public void testLineSegIntersectLineSeg() {
            // Case 1 Not Intersecting
            LineSeg l1 = new LineSeg(new Point(0, 0), new Point(5, 5));
            LineSeg l2 = new LineSeg(new Point(0, 1), new Point(5, 6));
            assertFalse(l1.intersect(l2));	

            // Case 2 Intersecting
            LineSeg l3 = new LineSeg(new Point(5, 0), new Point(0, 5));
            assertFalse(l1.intersect(l3));	

            // Case 3 Line seg and line seg are starting at the same point 
            LineSeg l4 = new LineSeg(new Point(0, 0), new Point(5, 10));
            assertFalse(l1.intersect(l4));	
	}

// POINT TEST CASES
    // POINT INTERSECTS LINE SEG 
	@Test
	public void testPointIntersectLineSeg() {
            // Case 1 Not Intersecting
            LineSeg l1 = new LineSeg(new Point(0, 0), new Point(6, 6));
            Point p1 = new Point(4, 3);
            assertFalse(l1.intersect(p1));	

            // Case 2 Intersecting
            Point p2 = new Point(3, 3);
            assertTrue(l1.intersect(p2));	
	}

    //POINT INTERSECTS CIRCLE
    @Test
	public void testPointIntersectCircle() {
            // Case 1 Not Intersecting
            Point p1 = new Point(5, 3);
            Circle c1 = new Circle(new Point(0, 0), 5);
            assertFalse(c1.intersect(p1));	

            // Case 2 Intersecting
            Point p2 = new Point(3, 3);
            assertTrue(c1.intersect(p2));	

            //Case 3 Point and circle are just touching
            Point p3 = new Point(5, 0);
            assertTrue(c1.intersect(p3));
        }
    
    //POINT INTERSECTS RECTANGLE
	@Test
	public void testPointIntersectsRectangle() {
            // Case 1 Not Intersecting
            Rectangle r1 = new Rectangle(0, 4, 4, 0);
            Point p1 = new Point(5, 5);
            assertFalse(r1.intersect(p1));	

            // Case 2 Intersecting
            Point p2 = new Point(2, 2);
            assertTrue(r1.intersect(p2));	

            // Case 3 Point and rectangle are just touching
            Point p3 = new Point(4, 4);
            assertTrue(r1.intersect(p3));	
	}

    //POINT INTERSECTS POINT
	@Test
	public void testPointIntersectPoint() {
            // Case 1 Not Intersecting
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 1);
            assertFalse(p1.intersect(p2));	

            // Case 2 Intersecting
            Point p3 = new Point(0, 0);
            assertTrue(p1.intersect(p3));	
	}
	
}