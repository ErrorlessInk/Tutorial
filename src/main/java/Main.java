import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        Frame f = new Frame();
        Drawing d = new Drawing();
        f.add(d);
        d.setSize(400,500);
        d.setBackground(Color.white);

        f.setLayout(null);
        f.setSize(400,500);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                f.dispose();
            }
        });
        f.setVisible(true);
    }

}
