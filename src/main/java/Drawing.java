import java.awt.*;

public class Drawing extends Canvas {
    private Circle circle;

    public Drawing(){
        circle= new Circle(
                50,
                new Point(180,160),
                Color.RED
        );
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(0, 0, 100, 100);
        circle.draw(g);
    }
}
