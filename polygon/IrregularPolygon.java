package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        double perimeter = 0.0;
         for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double currentPoint = myPolygon.get(i);
            Point2D.Double nextPoint = myPolygon.get((i + 1) % myPolygon.size()); // Wrap around to the first point
            perimeter += currentPoint.distance(nextPoint);
        }
        return perimeter;
    }

    public double area() {
        // TODO: Calculate the area.
        double area = 0.0;
        int n = myPolygon.size();
        for (int i = 0; i < n; i++) {
            Point2D.Double currentPoint = myPolygon.get(i);
            Point2D.Double nextPoint = myPolygon.get((i + 1) % n);
            area += currentPoint.x * nextPoint.y;
            area -= nextPoint.x * currentPoint.y;
        }
        return Math.abs(area / 2.0);
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
                DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
                myDrawingTool.penDown();
                for (Point2D.Double point : myPolygon) {
                    myDrawingTool.move(point.x, point.y);
                }
                myDrawingTool.move(myPolygon.get(0).x, myPolygon.get(0).y); // Close the polygon
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
