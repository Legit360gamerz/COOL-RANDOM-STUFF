import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Draw canvas = new Draw();


    Frame(){

        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        this.setBackground(Color.BLACK);
        this.setSize(700,700);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

    }

}
