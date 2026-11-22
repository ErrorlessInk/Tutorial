import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import shapes.Shape;
import shapes.Circle;
import shapes.Rect;
import shapes.Square;

public class Drawing extends JPanel {
    private final ArrayList<Shape> shapes = new ArrayList<>();

    public Drawing(){
        shapes.add(new Circle(35,new Point(90,100),Color.RED));
        shapes.add(new Rect(100,60,new Point(180,65),Color.BLUE));
        shapes.add(new Square(65,new Point(340, 65), Color.GREEN));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    public void addCircle(int radius,Point position,Color color){
        shapes.add(new Circle(radius,position,color));
        repaint();
    }

    public void addRect(int width,int height,Point position,Color color){
        shapes.add(new Rect(width,height,position,color));
        repaint();
    }

    public void addSquare(int side,Point position,Color color){
        shapes.add(new Square(side,position,color));
        repaint();
    }
    public void clearShapes() {
        shapes.clear();
        repaint();
    }
    public void undoLast() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
    }
}
