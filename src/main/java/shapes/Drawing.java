package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;


public class Drawing extends JPanel {
    private final ShapeDB db =  new ShapeDB();
    public Drawing(){
        setBackground(Color.WHITE);
        db.add(new Circle(35,new Point(90,100),Color.RED));
        db.add(new Rect(100,60,new Point(180,65),Color.BLUE));
        db.add(new Square(65,new Point(340, 65), Color.GREEN));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        db.drawAll(g);
    }

    public void addCircle(int radius,Point position,Color color){
        db.add(new Circle(radius,position,color));
        repaint();
    }

    public void addRect(int width,int height,Point position,Color color){
        db.add(new Rect(width,height,position,color));
        repaint();
    }

    public void addSquare(int side,Point position,Color color){
        db.add(new Square(side,position,color));
        repaint();
    }

    public void clearShapes() {
        db.clear();
        repaint();
    }
    public void undo() {
        if (db.undo()) {
            repaint();
        }
    }

    public boolean canUndo() {
        return db.hasShapes();
    }

    public void addTriangle(int size, Point pos, Color color) {
        db.add(new Triangle(pos, color, size));
        repaint();
    }
}
