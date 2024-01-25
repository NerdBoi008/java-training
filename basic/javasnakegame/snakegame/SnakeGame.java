import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public final class SnakeGame extends JFrame implements ActionListener, KeyListener {

    public static final Companion Companion = new Companion();

    private final int gridSize = 20;
    private final int numGrids = 20;
    private final int totalGrids;

    private final int[] snakeX;
    private final int[] snakeY;

    private int snakeLength;

    private String direction;

    private int appleX;
    private int appleY;

    private Timer timer;
    
    private final JLabel gameOverLabel;

    public SnakeGame() {
        
        super("Snake Game");

        this.totalGrids = this.numGrids * this.numGrids;
        this.snakeX = new int[this.totalGrids];
        this.snakeY = new int[this.totalGrids];
        this.snakeLength = 3;
        this.direction = "RIGHT";
        
        JLabel gameOverLabel = new JLabel("Game over! Press 'R' to restart.", 0);
        gameOverLabel.setVisible(false);
        this.gameOverLabel = gameOverLabel;
        
        this.setDefaultCloseOperation(3);
        this.getContentPane().setBackground(Color.BLACK);
        this.getContentPane().setPreferredSize(new Dimension(this.numGrids * this.gridSize, this.numGrids * this.gridSize));

        this.pack();

        this.initializeGame();

        this.timer = new Timer(200, (ActionListener)this); //snake moving speed

        if (this.timer != null) {
            this.timer.start();
        }

        this.gameOverLabel.setFont(new Font("Arial", 1, 20));
        this.gameOverLabel.setForeground(Color.WHITE);
        this.gameOverLabel.setBounds(100, 200, 400, 50);
        this.add((Component)this.gameOverLabel);

        this.addKeyListener((KeyListener)this);
        this.setFocusable(true);
    }

    private final void initializeGame() {
        this.snakeLength = 3;
        int i = 0;

        for(int var2 = this.snakeLength; i < var2; ++i) {
            this.snakeX[i] = this.numGrids * this.gridSize / 2 - i * this.gridSize;
            this.snakeY[i] = this.numGrids * this.gridSize / 2;
        }

        this.spawnApple();
    }

    private final void spawnApple() {
        this.appleX = (int)(Math.random() * (double)this.numGrids) * this.gridSize;
        this.appleY = (int)(Math.random() * (double)this.numGrids) * this.gridSize;
    }

    private final void move() {

        for(int i = this.snakeLength; 0 < i; --i) {
            this.snakeX[i] = this.snakeX[i - 1];
            this.snakeY[i] = this.snakeY[i - 1];
        }

        switch (this.direction) {
            case "UP":
                this.snakeY[0] -= this.gridSize;
                break;
            case "DOWN":
                this.snakeY[0] += this.gridSize;
                break;
            case "LEFT":
                this.snakeX[0] -= this.gridSize;
                break;
            case "RIGHT":
                this.snakeX[0] += this.gridSize;
        }

    }

    private final void checkCollision() {
        if (this.snakeX[0] < 0 || this.snakeX[0] >= this.numGrids * this.gridSize || this.snakeY[0] < 0 || this.snakeY[0] >= this.numGrids * this.gridSize) {
            this.gameOver();
        }

        int i;
        for(i = this.snakeLength; 1 < i; --i) {
            if (this.snakeX[0] == this.snakeX[i] && this.snakeY[0] == this.snakeY[i]) {
                this.gameOver();
            }
        }

        if (this.snakeX[0] == this.appleX && this.snakeY[0] == this.appleY) {
            i = this.snakeLength++;
            this.spawnApple();
        }

    }

    private final void restartGame() {
        
        this.gameOverLabel.setVisible(false);

        this.initializeGame();

        if (this.timer != null) {
            this.timer.start();
        }

        this.repaint();
    }

    private final void gameOver() {

        if (this.timer != null) {
            this.timer.stop();
        }

        System.out.println("Game Over! Press 'R' to restart.");
        this.gameOverLabel.setVisible(true);

    }

    private final void draw(Graphics Graphics) {
        int i = 0;

        for(int var3 = this.snakeLength; i < var3; ++i) {
            Graphics.setColor(Color.GREEN);
            Graphics.fillRect(this.snakeX[i], this.snakeY[i], this.gridSize, this.gridSize);
        }

        Graphics.setColor(Color.RED);
        Graphics.fillRect(this.appleX, this.appleY, this.gridSize, this.gridSize);
    }

    public void actionPerformed(ActionEvent e) {
        this.move();
        this.checkCollision();
        this.repaint();
    }

    public void paint(Graphics Graphics) {
        super.paint(Graphics);
        this.draw(Graphics);
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if (e != null) {
            switch (e.getKeyCode()) {
                case 38:
                    this.direction = "UP";
                    return;
                case 40:
                    this.direction = "DOWN";
                    return;
                case 37:
                    this.direction = "LEFT";
                    return;
                case 39:
                    this.direction = "RIGHT";
                    return;
                case 82:
                    this.restartGame();
                    return;
                
                default:
                    break;
            }
        }
    }

    public void keyReleased(KeyEvent e) {}

        
    public static final class Companion {
        private Companion() {
        }

        public final void main(String[] args) {
            new SnakeGame().setVisible(true);
        }
    }
}
