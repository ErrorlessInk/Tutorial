package shapes;
import java.awt.*;
import java.util.ArrayList;

class ShapeDB {
    private final ArrayList<Shape> shapes = new ArrayList<>();
    void add(Shape s) { shapes.add(s); }
    void drawAll(Graphics g) {
        for (Shape s : shapes) s.draw(g);
    }
    void clear() { shapes.clear(); }
    boolean undo() {
        if (shapes.isEmpty()) return false;
        shapes.remove(shapes.size() - 1);
        return true;
    }
    boolean hasShapes() {
        return !shapes.isEmpty();
    }
}
