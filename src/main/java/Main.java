import java.io.*;

public class Main {
    public static Triangle parseTriangleCoords(String coordinates) throws Exception {
        if (coordinates == null) {
            throw new Exception("Invalid params");
        }

        String[] coords = coordinates.split(" ");
        if (coords.length != 6) {
            throw new Exception("Invalid params");
        }

        Point pointA;
        Point pointB;
        Point pointC;

        try {
            pointA = new Point(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]));
            pointB = new Point(Integer.valueOf(coords[2]), Integer.valueOf(coords[3]));
            pointC = new Point(Integer.valueOf(coords[4]), Integer.valueOf(coords[5]));

        } catch (NumberFormatException e) {
            throw e;
        }
        return new Triangle(pointA, pointB, pointC);
    }

    public static void writeResult(String fileName, Triangle maxTriangle) {
        if (maxTriangle == null) {
            System.out.println("Input file does not contain valid triangles");
            return;
        }
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(maxTriangle.toString());
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Enter correct output file name.");
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }

    public static void main(String[] args){
        String coords;
        Triangle maxTriangle = null;

        try (FileInputStream file = new FileInputStream(args[0]);
             BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            while ((coords = br.readLine()) != null) {
                try {
                    Triangle currentTriangle = parseTriangleCoords(coords);
                    if (!currentTriangle.isCorrectTriangle() || !currentTriangle.isOscelesTriangle()) {
                        continue;
                    }

                    if (maxTriangle == null || maxTriangle.getArea() < currentTriangle.getArea()) {
                        maxTriangle = currentTriangle;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Number format error");
                } catch (Exception e) {
                    System.out.println("Something Wrong");
                }
            }

            writeResult(args[1],  maxTriangle);

        } catch (FileNotFoundException e) {
            System.out.println("Enter correct input file name.");
        } catch (Exception e) {
            System.out.println("Something Wrong");
        }
    }
}
