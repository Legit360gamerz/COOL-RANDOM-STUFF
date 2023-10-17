import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Draw extends JPanel implements ActionListener {

    public int width = 600;
    public int height = 600;

    private int rows = 10;
    private int cols = 10;

    int cellHeight = height/rows;
    int cellWidth = width/cols;
    Random rand = new Random();

    int[][]randomRectLocation;


    public Draw(){
        this.setSize(width, height);
        this.setBackground(Color.GRAY);
        randomRectLocation = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                randomRectLocation[i][j] = generateRandArray()[i][j];
                System.out.print(randomRectLocation[i][j]+" ");
            }
            System.out.println("");
        }


    }
    public void paint(Graphics g){
        Timer time = new Timer(100, this);
        time.start();
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.fillOval(300,300, 70,70);

        int currentRow = 1;
        for(int i = 0; i < rows; i++){
            g2D.setColor(Color.BLACK);
            g2D.drawLine(0, cellHeight*currentRow, width, cellHeight*currentRow);
            currentRow++;
        }
        int currentCol = 1;
        for(int i = 0; i < cols; i++){
            g2D.setColor(Color.RED);
            g2D.drawLine(cellWidth*currentCol, 0, cellWidth*currentCol,height);
            currentCol++;
        }
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j <cols; j++){
                int xLocation = i*cellWidth;
                int yLocation = j*cellHeight;
                if(randomRectLocation[i][j] == 1){
                    int randColor = rand.nextInt(255);
                    g2D.setColor(new Color(randColor));
                    g2D.fillRect(xLocation, yLocation, cellWidth, cellHeight);
                }
                else if(randomRectLocation[i][j] == 0){
                    g2D.setColor(Color.BLACK);
                    g2D.fillRect(xLocation, yLocation, cellWidth, cellHeight);
                }
            }
        }


    }
    public int[][] generateRandArray(){
        int[][]arr = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[rand.nextInt(10)][rand.nextInt(10)] = rand.nextInt(2);

            }

        }
        return arr;
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                randomRectLocation[i][j] = generateRandArray()[i][j];
                //System.out.print(randomRectLocation[i][j]+" ");
            }
            //System.out.println("");
            repaint();
        }
    }
}
