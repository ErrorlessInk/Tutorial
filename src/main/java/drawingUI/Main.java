package drawingUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import shapes.Drawing;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            // 1. Create window and drawing panel
            JFrame frame = new JFrame("Shape Studio");
            Drawing drawing = new Drawing();

            // 2. Create controls
            JPanel controls = new JPanel(new GridLayout(2, 1));

            JComboBox<String> choice = new JComboBox<>(
                    new String[]{"Circle", "Rect", "Square","Triangle"});

            JSlider sizeSlider = new JSlider(10, 100, 30);
            JSlider widthSlider = new JSlider(10, 200, 60);

            JButton pickColor = new JButton("Pick colour");
            final Color[] chosenColor = {Color.MAGENTA};

            // 3. First row: Shape and Size
            JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row1.add(choice);
            row1.add(new JLabel("Size:"));
            row1.add(sizeSlider);

            // 4. Second row: Width and Colour
            JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row2.add(new JLabel("Width:"));
            row2.add(widthSlider);
            row2.add(pickColor);

            controls.add(row1);
            controls.add(row2);

            // 5. Colour selection
            pickColor.addActionListener(e -> {
                Color result = JColorChooser.showDialog(
                        frame, "Choose a colour", chosenColor[0]);

                if (result != null) {
                    chosenColor[0] = result;
                }
            });

            // 6. Bottom buttons
            JPanel actions = new JPanel(new FlowLayout());

            JButton clear = new JButton("Clear all");
            JButton undo = new JButton("Undo");

            actions.add(clear);
            actions.add(undo);

            undo.setEnabled(drawing.canUndo());

            clear.addActionListener(e -> {
                drawing.clearShapes();
                undo.setEnabled(drawing.canUndo());
            });

            undo.addActionListener(e -> {
                drawing.undo();
            });

            // 7. Mouse listener
            drawing.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String selected = (String) choice.getSelectedItem();
                    int size = sizeSlider.getValue();
                    int width = widthSlider.getValue();

                    if ("Circle".equals(selected)) {
                        drawing.addCircle(
                                size, e.getPoint(), chosenColor[0]);

                    } else if ("Rect".equals(selected)) {
                        drawing.addRect(
                                width, size, e.getPoint(), chosenColor[0]);

                    } else if ("Square".equals(selected)) {
                        drawing.addSquare(
                                size, e.getPoint(), chosenColor[0]);
                    }else if ("Triangle".equals(selected)) {
                        drawing.addTriangle(
                                size, e.getPoint(), chosenColor[0]);
                    }
                    undo.setEnabled(drawing.canUndo());
                }
            });

            // 8. Window layout
            frame.setLayout(new BorderLayout());

            frame.add(controls, BorderLayout.NORTH);
            frame.add(drawing, BorderLayout.CENTER);
            frame.add(actions, BorderLayout.SOUTH);

            // 9. Window settings
            frame.setSize(800, 560);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
