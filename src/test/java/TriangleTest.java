import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testCorrectTriangle() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 0), new Point(0, 5));
        assertTrue(triangle.isCorrectTriangle());
    }

    @Test
    public void testIncorrectTriangle() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 5), new Point(5, 5));
        assertFalse(triangle.isCorrectTriangle());
    }

    @Test
    public void testOscelesTriangle() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 5), new Point(5, -5));
        assertTrue(triangle.isOscelesTriangle());
    }

    @Test
    public void testNotOscelesTriangle(){
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 5), new Point(5, 3));
        assertFalse(triangle.isOscelesTriangle());
    }

    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 0), new Point(0, 5));
        assertEquals(triangle.getArea(), 12.5, 0);
    }

}