import java.awt.*;

public class Drawing extends Canvas {
    private Circle circle;
    private Rect rect;
    private Square square;

    public Drawing(){
        circle= new Circle(
                50,
                new Point(180,160),
                Color.RED
        );
        rect = new Rect(
                120,
                80,
                new Point(50,250),
                Color.BLUE
        );
        square = new Square(
                50,
                new Point(180,160),
                Color.GREEN
        );
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(0, 0, 100, 100);
        circle.draw(g);
        rect.draw(g);
        square.draw(g);
    }
}
