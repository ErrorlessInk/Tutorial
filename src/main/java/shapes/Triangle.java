package shapes;

import java.awt.*;


public class Triangle extends Shape {
    private final int size;

    public Triangle(Point pos, Color color, int size) {
        super(pos, color);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        int[] xs = {position.x, position.x - size, position.x + size};
        int[] ys = {position.y - size, position.y + size, position.y + size};
        g.setColor(color);
        g.fillPolygon(xs, ys, 3);
    }
}

