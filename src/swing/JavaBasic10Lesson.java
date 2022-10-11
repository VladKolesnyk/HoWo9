package swing;

import org.w3c.dom.css.RGBColor;
import org.w3c.dom.html.HTMLParagraphElement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JavaBasic10Lesson extends JFrame {

    final private Color[] COLORS = {Color.red, Color.blue, Color.green,
            Color.black, Color.pink, Color.gray, Color.magenta};
    private Random random = new Random();

    public static void main(String[] args) {
        new JavaBasic10Lesson();
    }

    public JavaBasic10Lesson() {
        setTitle("Hello Swing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);

        CanvasPanel canvasPanel = new CanvasPanel();
        canvasPanel.setBackground(Color.white);

        Button button = new Button("Repaint");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Repaint");
                canvasPanel.repaint();
            }
        });


        add(canvasPanel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics graphics) {
            super.paint(graphics);
            //рисуем что хотим
            for (int i = 0; i < 100; i++) {
                graphics.setColor(COLORS[random.nextInt(COLORS.length)]);
                int x = random.nextInt(500);
                int y = random.nextInt(400);
                int dx = random.nextInt(100);
                int dy = random.nextInt(100);
                if (random.nextBoolean()) {
                    graphics.fillRect(x, y, dx, dy);
                } else {
                    graphics.fillOval(x, y, dx, dy);
                }
            }
        }
    }
}
