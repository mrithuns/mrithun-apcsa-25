package polygon;

import java.awt.geom.*; // for Point2D.Double

public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();
        double[][] parallelogramPoints = { { 10, 20 }, { 100, 30 }, { -60, 60 }, { 150, 50 } };
        for (double[] p: parallelogramPoints) {
            Point2D.Double point = new Point2D.Double(p[0],p[1]);
            myPolygon.add(point);
        }
        // draw is a no-op stub in this environment
        myPolygon.draw();
        System.out.println("Perimeter: " + myPolygon.perimeter());
        System.out.println("Area: " + myPolygon.area());

        TestSuite.run();
    }
    
}
