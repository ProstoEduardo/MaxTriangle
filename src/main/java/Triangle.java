public class Triangle {
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    private double AB() {
        return getLengthBetweenPoints(pointA, pointB);
    }

    private double BC() {
        return getLengthBetweenPoints(pointB, pointC);
    }

    private double AC() {
        return getLengthBetweenPoints(pointA, pointC);
    }

    static double getLengthBetweenPoints(Point a, Point b) {
        return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) +
                (a.getY() - b.getY()) * (a.getY() - b.getY())
        );
    }

    public boolean isCorrectTriangle() {
        if (AB() + AC() > BC() && BC() + AC() > AB() && AB() + BC() > AC()) {
            return true;
        }
        return false;
    }

    public boolean isOscelesTriangle() {
        if (AB() == AC() || BC() == AC() || AB() == BC()) {
            return true;
        }
        return false;
    }

    public double getArea() {

        int firstPart = (pointA.x - pointC.x) * (pointB.y - pointC.y);
        int secondPart = (pointB.x - pointC.x) * (pointA.y - pointC.y);
        return Math.abs(0.5 * (firstPart - secondPart));
    }

    @Override
    public String toString() {
        return pointA + " " + pointB + " " + pointC;
    }
}
