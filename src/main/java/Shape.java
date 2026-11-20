import java.awt.*;

public abstract class Shape {
    protected Point position;
    protected Color color;

    public Shape(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public abstract void draw(Graphics g);
}
